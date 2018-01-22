package kamocinekfa


class AdminController {

    def index() {}
    /****Player***/
    def showPlayers() {
        def players = Player.findAll()
        [
                players: players
        ]
    }

    def deletePlayer(int id) {
        println "delete player: " + id
        def player = Player.get(id)
        player.delete(flush: true)
        redirect(controller: 'admin', action:'showPlayers')
    }

    def addPlayer() {
        params.put('userRole', UserRole.findByRole("Player"))
//        params.put('courses', null)
        def player = new Player(params)
        player.validate()
        if (player.hasErrors()) {
            def players = Player.findAll()
            render(view: 'showPlayers', model: [player: player, players: players])
        } else {
            player.save(flush: true)
            redirect(controller: 'admin', action: "showPlayers")
        }
    }

    def editPlayer(int id) {
        def player = Player.get(id)
        def players = Player.findAll()
        render(view: 'showPlayers', model: [player: player, players: players, id: id])
    }

    def updatePlayer() {

        def player = Player.findById(params.id)

        params.put('userRole', UserRole.findByRole("Player"))
        def tempPlayer = new Player(params)

        tempPlayer.validate()
        if(!tempPlayer.hasErrors()) {
            println("hereee")
            player.name = tempPlayer.name
            player.lastname = tempPlayer.lastname
            player.email = tempPlayer.email
            player.birthdate = tempPlayer.birthdate
            player.height = tempPlayer.height
            player.weight = tempPlayer.weight
            player.save(flush: true)
            redirect(controller: 'admin', action: 'showPlayers')
        } else {
            def players = Player.findAll()
            render(view: 'showPlayers', model: [player: tempPlayer, players: players, id: params.id])
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
        coach.delete(flush: true)
        redirect(controller: 'admin', action:'showCoaches')
    }

    def addCoach() {
        params.put('userRole', UserRole.findByRole("Coach"))
        def coach = new Coach(params)
        coach.validate()
        if (coach.hasErrors()) {
            def coaches = Coach.findAll()
            render(view: 'showCoaches', model: [coach: coach, coaches: coaches])
        } else {
            coach.save(flush: true)
            redirect(controller: 'admin', action: "showCoaches")
        }
    }

    def editCoach(int id) {
        def coach = Coach.get(id)
        def coaches = Coach.findAll()
        render(view: 'showCoaches', model: [coach: coach, coaches: coaches, id: id])
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
            def coaches = Coach.findAll()
            render(view: 'showCoaches', model: [coach: tempCoach, coaches: coaches, id: params.id])
        }
    }
    /****Course***/
    def showCourses() {
        def courses = Course.findAll()
        def coaches = Coach.findAll()
        [
                courses: courses,
                coaches: coaches
        ]
    }

    def deleteCourse(int id) {
        println "delete course: " + id
        def course = Course.get(id)
        course.delete(flush: true)
        redirect(controller: 'admin', action:'showCourses')
    }

    def addCourse() {
        def course = new Course(params)
        course.validate()
        if (course.hasErrors()) {
            def courses = Course.findAll()
            def coaches = Coach.findAll()
            render(view: 'showCourses', model: [course: course, courses: courses, coaches: coaches])
        } else {
            course.save(flush: true)
            redirect(controller: 'admin', action: "showCourses")
        }
    }

    def editCourse(int id) {
        def course = Course.get(id)
        def courses = Course.findAll()

        def coach = course.coach
        def coaches = Coach.findAll()
        render(view: 'showCourses', model: [course: course, courses: courses, id: id,
                                            coaches: coaches, coach: coach.id])
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
            course.coach = tempCourse.coach // przetestowac
            course.save(flush: true)
            redirect(controller: 'admin', action: 'showCourses')
        } else {

            def courses = Course.findAll()
            def coach = tempCourse.coach
            def coaches = Coach.findAll()
            render(view: 'showCourses', model: [course: tempCourse, courses: courses, id: params.id,
                                                coach: coach.id, coaches: coaches])
        }
    }

}
