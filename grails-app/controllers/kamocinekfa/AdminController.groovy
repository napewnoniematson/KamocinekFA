package kamocinekfa

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class AdminController {

    def springSecurityService

    def index() {}
    /****Player***/
    def home() {
        def admin = Admin.findByUser(springSecurityService.currentUser)
        [
                admin: admin
        ]
    }

    def showPlayers() {
        def players = Player.findAll()
        [
                players: players
        ]
    }

    def deletePlayer(int id) {
        println "delete player: " + id
        def player = Player.get(id)
        if (player != null) {
            def courses = player.courses
            courses.each {
                it.removeFromPlayers(player)
            }
            def user = player.user
            UserAuthority.removeAll(user)
            player.delete(flush: true)
            user.delete(flush: true)
            redirect(controller: 'admin', action:'showPlayers')
        } else {
            render (view: "../notFound")
        }
    }

    def addPlayer() {}

    def savePlayer() {

        def user = new User(
                username: params.username,
                password: params.password)

        def player = new Player(
                name: params.name,
                lastname: params.lastname,
                email: params.email,
                birthdate: params.birthdate,
                height: params.height,
                weight: params.weight,
                user: user)
        user.validate()
        player.validate()

        if (user.hasErrors() || player.hasErrors()) {
            render(view: 'addPlayer', model: [user: user, player: player])
        } else {
            player.save(flush: true)
            UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
            redirect(controller: 'admin', action: "showPlayers")
        }
    }

    def editPlayer(int id) {
        def player = Player.get(id)
        if (player != null)
            render(view: 'editPlayer', model: [player: player, user: player?.user, id: id])
        else
            render (view: "../notFound")
    }

    def updatePlayer() {
        def player = Player.findById(params.id)
        if (player != null) {
            def user = player.user

//        def tempUser = new User(
//                username: params.username,
//                password: params.password)

            def tempPlayer = new Player(
                    name: params.name,
                    lastname: params.lastname,
                    email: params.email,
                    birthdate: params.birthdate,
                    height: params.height,
                    weight: params.weight,
                    user: user)

//        tempUser.validate()
            tempPlayer.validate()
            if(/*!tempUser.hasErrors() &&*/ !tempPlayer.hasErrors()) {
//            user.password = tempUser.password
                player.name = tempPlayer.name
                player.lastname = tempPlayer.lastname
                player.email = tempPlayer.email
                player.birthdate = tempPlayer.birthdate
                player.height = tempPlayer.height
                player.weight = tempPlayer.weight
                player.save(flush: true)
                redirect(controller: 'admin', action: 'showPlayers')
            } else {
                render(view: 'editPlayer', model: [player: tempPlayer,/* user: tempUser,*/ id: params.id])
            }
        } else {
            redirect(controller: 'admin', action: 'showPlayers')
        }


    }
    /****Coach***/
    def showCoaches() {
        def coaches = Coach.findAll()
        [
                coaches: coaches
        ]
    }

    def deleteCoach(int id) {
        println "delete coach: " + id
        def coach = Coach.get(id)
        if (coach != null) {
            def courses = coach.courses
            courses.each {
                it.coach = null
            }
            def user = coach.user
            UserAuthority.removeAll(user)
            coach.delete(flush: true)
            user.delete(flush: true)
            redirect(controller: 'admin', action:'showCoaches')
        } else {
            render (view: "../notFound")
        }
    }

    def addCoach() {}

    def saveCoach() {
        def user = new User(
                username: params.username,
                password: params.password)

        def coach = new Coach(
                name: params.name,
                lastname: params.lastname,
                email: params.email,
                user: user)
        user.validate()
        coach.validate()
        if (user.hasErrors() && coach.hasErrors()) {
            render(view: 'addCoach', model: [user: user, coach: coach])
        } else {
            coach.save(flush: true)
            UserAuthority.create(user, Authority.findByAuthority("ROLE_COACH"), true)
            redirect(controller: 'admin', action: "showCoaches")
        }
    }

    def editCoach(int id) {
        def coach = Coach.get(id)
        if (coach != null) {
            render(view: 'editCoach', model: [coach: coach, id: id])
        } else {
            render(view: "../notFound")
        }
    }

    def updateCoach() {
        def coach = Coach.findById(params.id)
        if (coach != null) {
            def user = coach.user
            def tempCoach = new Coach(
                    name: params.name,
                    lastname: params.lastname,
                    email: params.email,
                    user: user)
            tempCoach.validate()
            if(!tempCoach.hasErrors()) {
                coach.name = tempCoach.name
                coach.lastname = tempCoach.lastname
                coach.email = tempCoach.email
                coach.save(flush: true)
                redirect(controller: 'admin', action: 'showCoaches')
            } else {
                render(view: 'editCoach', model: [coach: tempCoach, id: params.id])
            }
        } else {
            redirect(controller: 'admin', action: 'showCoaches')
        }


    }
    /****Course***/
    def showCourses() {
        def courses = Course.findAll()
        [
                courses: courses,
        ]
    }

    def deleteCourse(int id) {
        println "delete course: " + id
        def course = Course.get(id)
        if (course != null) {
            def coach = course.coach
            coach.removeFromCourses(course)
            course.delete(flush: true)
            redirect(controller: 'admin', action:'showCourses')
        } else {
            render(view: "../notFound")
        }
    }

    def addCourse() {
        def coaches = Coach.findAll()
        [
                coaches: coaches
        ]
    }

    def saveCourse() {
        def course = new Course(params)
        def coach = course.coach
        course.validate()
        if (course.hasErrors()) {
            def coaches = Coach.findAll()
            render(view: 'addCourse', model: [course: course,
                                              coaches: coaches,
                                              coach: coach?.id])
        } else {
            course.save(flush: true)
            redirect(controller: 'admin', action: "showCourses")
        }
    }

    def editCourse(int id) {
        def course = Course.get(id)
        if (course != null) {
            def coach = course.coach
            def coaches = Coach.findAll()
            render(view: 'editCourse', model: [course: course,
                                               id: id,
                                               coaches: coaches,
                                               coach: coach?.id ])
        } else {
            render (view: "../notFound")
        }
    }

    def updateCourse() {
        def course = Course.findById(params.id)
        if (course != null) {
            def tempCourse = new Course(params)
            tempCourse.validate()
            if(!tempCourse.hasErrors()) {
                course.title = tempCourse.title
                course.startDate = tempCourse.startDate
                course.endDate = tempCourse.endDate
                course.maxPlayers = tempCourse.maxPlayers
                course.coach = tempCourse.coach
                course.save(flush: true)
                redirect(controller: 'admin', action: 'showCourses')
            } else {
                def coach = tempCourse.coach
                def coaches = Coach.findAll()
                render(view: 'editCourse', model: [course: tempCourse, id: params.id,
                                                   coach: coach?.id, coaches: coaches])
            }
        } else {
            redirect(controller: 'admin', action: 'showCourses')
        }
    }
}
