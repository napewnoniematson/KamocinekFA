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
        def player = Player.get(id)
        player.delete()
        redirect(controller: 'admin', action:'showPlayers')
    }

    def showCoaches() {
        def coaches = Coach.findAll()
        [
                coaches: coaches
        ]
    }

    def deleteCoach(int id) {
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
            coach.save()
            redirect(controller: 'admin', action: "showCoaches")
        }
    }

    def showCourses() {
        def courses = Course.findAll()
        [
                courses: courses
        ]
    }

    def deleteCourse(int id) {
        def course = Course.get(id)
        course.delete()
        redirect(controller: 'admin', action:'showCourses')
    }

}
