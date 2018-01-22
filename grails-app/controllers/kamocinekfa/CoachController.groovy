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
        def coach = Coach.findByName("Maciej")
        [
                coach: coach
        ]
    }

    def editProfile(int id) {
        //to id trzeba wywalic jakos
        def coach = Coach.findById(id)
        [
                coach: coach
        ]

    }

    def update() {
        def coach = Coach.findById(2)

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

    def showCourse(int id) {
        def course = Course.get(id)
        [
                title: course.title,
                players: course.players
        ]
    }
}
