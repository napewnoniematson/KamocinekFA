package kamocinekfa


class AdminController {

    def index() {}
    /****Player***/
    def home() {
        def admin = Admin.findById(1)
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
        def courses = player.courses
        courses.each {
            it.removeFromPlayers(player)
        }
        player.delete(flush: true)
        redirect(controller: 'admin', action:'showPlayers')
    }

    def addPlayer() {}

    def savePlayer() {
        params.put('userRole', UserRole.findByRole("Player"))
        def player = new Player(params)
        player.validate()
        if (player.hasErrors()) {
            render(view: 'addPlayer', model: [player: player])
        } else {
            player.save(flush: true)
            redirect(controller: 'admin', action: "showPlayers")
        }
    }

    def editPlayer(int id) {
        def player = Player.get(id)
        render(view: 'editPlayer', model: [player: player, id: id])
    }

    def updatePlayer() {
        def player = Player.findById(params.id)
        params.put('userRole', UserRole.findByRole("Player"))
        def tempPlayer = new Player(params)
        tempPlayer.validate()
        if(!tempPlayer.hasErrors()) {
            player.name = tempPlayer.name
            player.lastname = tempPlayer.lastname
            player.email = tempPlayer.email
            player.birthdate = tempPlayer.birthdate
            player.height = tempPlayer.height
            player.weight = tempPlayer.weight
            player.save(flush: true)
            redirect(controller: 'admin', action: 'showPlayers')
        } else {
            render(view: 'editPlayer', model: [player: tempPlayer, id: params.id])
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
        def courses = coach.courses
        courses.each {
            it.coach = null
        }
        coach.delete(flush: true)
        redirect(controller: 'admin', action:'showCoaches')
    }

    def addCoach() {}

    def saveCoach() {
        params.put('userRole', UserRole.findByRole("Coach"))
        def coach = new Coach(params)
        coach.validate()
        if (coach.hasErrors()) {
            render(view: 'addCoach', model: [coach: coach])
        } else {
            coach.save(flush: true)
            redirect(controller: 'admin', action: "showCoaches")
        }
    }

    def editCoach(int id) {
        def coach = Coach.get(id)
        render(view: 'editCoach', model: [coach: coach, id: id])
    }

    def updateCoach() {
        def coach = Coach.findById(params.id)
        params.put('userRole', UserRole.findByRole("Coach"))
        def tempCoach = new Coach(params)
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
        def coach = course.coach
        coach.removeFromCourses(course)
        course.delete(flush: true)
        redirect(controller: 'admin', action:'showCourses')
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
        def coach = course.coach
        def coaches = Coach.findAll()
        render(view: 'editCourse', model: [course: course,
                                           id: id,
                                           coaches: coaches,
                                           coach: coach?.id ])
    }

    def updateCourse() {
        def course = Course.findById(params.id)
        params.put('userRole', UserRole.findByRole("Course"))
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
    }
}
