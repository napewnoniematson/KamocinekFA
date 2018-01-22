package kamocinekfa

class CoachController {

    def index() {}

    def showProfile() {
        def coach = Coach.findByName("Maciej")
        [
                coach: coach
        ]
    }

    def editProfile() {
        def coach = Coach.findById(params.id)
        [
                coach: coach
        ]
    }

    def update() {
        println "update id: " + params.id
        def coach = Coach.findById(params.id)

        params.put('userRole', UserRole.findByRole("Coach"))
        def tempCoach = new Coach(params)

        tempCoach.validate()
        if(!tempCoach.hasErrors()) {
            coach.name = tempCoach.name
            coach.lastname = tempCoach.lastname
            coach.email = tempCoach.email
            coach.save(flush: true)
            redirect(controller: 'coach', action: 'showProfile')
        } else {
            render(view: 'editProfile', model: [coach: tempCoach])
        }
    }

    def showCourses() {
        //tu bedzie zalogowany Coach
        def coach = Coach.findByName("Jacek")
        [
                courses: coach.courses
        ]
    }

    // ogarnac jak ktos z palca wklepie jakis id ktorego nie ma
    def showCourse(int id) {
        def course = Course.get(id)
        [
                title: course.title,
                players: course.players
        ]
    }
}
