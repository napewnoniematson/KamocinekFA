package kamocinekfa

class CoachController {

    def index() {
        def publisher = (params.selectedPublisher) ? Coach.get(params.selectedPublisher) : ''
        [
                publishers: Coach.findAll(),
                selectedPublisher: params.selectedPublisher,
                selectedPublisherName: (params.selectedPublisher)? Coach.get(params.selectedPublisher).name : '',
                books: (publisher) ? Course.findAllByCoach(publisher) : []
        ]
    }

    def showProfile() {
        //tu bedzie zalogowany Coach
        def coach = Coach.findByName("Jacek")
        [
                name: coach.name,
                lastname: coach.lastname,
                email: coach.email
        ]
    }

    def editProfile() {
        //tu bedzie zalogowany Coach
        println "xDDDDD"
        def coach = Coach.findByName("Jacek")
        [

        ]
    }

    def showCourses() {
        //tu bedzie zalogowany Coach
        def coach = Coach.findByName("Jacek")
        [
                courses: coach.courses
        ]
    }

    def showCourse(int id) {
        def course = Course.get(id)
        [
                title: course.title,
                players: course.players
        ]
    }
}
