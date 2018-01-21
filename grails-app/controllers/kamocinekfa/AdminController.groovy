package kamocinekfa


class AdminController {

    def index() {}

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

}
