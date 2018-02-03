package kamocinekfa

import java.util.stream.Collectors

class PlayerController {

    def index() {}

    def home() {
        def player = Player.findByName("Enzo")
        [
                player: player
        ]
    }

    def showProfile() {
        def player = Player.findByName("Enzo")
        [
                player: player
        ]
    }

    def showOwnCourses() {
        //tu bedzie zalogowany player
        def player = Player.findByName("Enzo")
        [
                courses: player.courses
        ]
    }

    // ogarnac jak ktos z palca wklepie jakis id ktorego nie ma
    def showCourse(int id) {
        def course = Course.get(id)
        [
                title: course.title,
                coach: course.coach.name + " " + course.coach.lastname,
                startdate: course.startDate,
                enddate: course.endDate,
                maxplayers: course.maxPlayers,
                actualplayers: course.players.size()

        ]
    }
    def editProfile() {
        def player = Player.findById(params.id)
        [
                player: player,
                id: params.id
        ]
    }

    def update() {
        println "update id: " + params.id
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
            redirect(controller: 'player', action: 'showProfile')
        } else {
            render(view: 'editProfile', model: [player: tempPlayer, id: params.id])
        }
    }

    def showCourses() {
        def courses = Course.findAll()
        [
                courses: courses
        ]
    }

    def join() {

        def player = Player.findById(params.id_player)
        println "id course: " + params.id_course
        player.courses.stream()
                .filter({course -> course.players.size() == 0})
                .collect(Collectors.toList())
                .forEach()

//        sprawdzenie warunku zeby nie dodac dwa razy tego samego kursu

//        def course = Course.findById(params.id_course)
//        if (course.players.size() < course.maxPlayers) {
//            def player = Player.findById(params.id_player)
//            if (player.courses.stream().filter())
//
//            player.courses.add(course)
//            player.save(flush: true)
//        }
//
//
        redirect(controller: 'player', action: 'showCourses')






    }

}
