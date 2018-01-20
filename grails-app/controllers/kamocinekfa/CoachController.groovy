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

    def testxd() {
        def coach = (params.selectedCoach) ? Coach.get(params.selectedCoach) : ''

        [
                coaches: Coach.findAll(),
                selectedCoach: params.selectedCoach,
                selectedCoachName: (params.selectedCoach) ? Coach.get(params.selectedCoach).name : '',
                courses: (Coach) ? Course.findAllByCoach(coach) : []
        ]
        println ("Class: " + coach.class + " | coach.name: " + (Coach)coach.name)
    }
}
