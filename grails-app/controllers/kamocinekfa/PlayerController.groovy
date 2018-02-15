package kamocinekfa

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_PLAYER')
class PlayerController {
    def springSecurityService

    def index() {}

    def home() {
        def player = Player.findByUser(springSecurityService.currentUser)
        [
                player: player
        ]
    }

    def showProfile() {
        def player = Player.findByUser(springSecurityService.currentUser)
        [
                player: player
        ]
    }

    def showOwnCourses() {
        def player = Player.findByUser(springSecurityService.currentUser)
        [
                courses: player?.courses
        ]
    }

    def showCourse(int id) {
        def course = Course.get(id)
        if (course == null) {
            render(view: "../notFound" )
        }
        [
                title: course?.title,
                coach: course?.coach?.name && course?.coach?.lastname ?
                        course?.coach?.name + " " + course?.coach?.lastname : "",
                startdate: course?.startDate,
                enddate: course?.endDate,
                maxplayers: course?.maxPlayers,
                actualplayers: course?.players?.size()
        ]
    }
    def editProfile() {
        def player = Player.findByUser(springSecurityService.currentUser)
        [
                player: player,
//                id: params.id
        ]
    }

    def update() {
//        println "update id: " + params.id
//        def player = Player.findById(params.id)
        def player = Player.findByUser(springSecurityService.currentUser)
        params.put('user', springSecurityService.currentUser)
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
            render(view: 'editProfile', model: [player: tempPlayer/*, id: player.id*/])
        }
    }

    def showCourses() {
        def courses = Course.findAll()
        [
                courses: courses
        ]
    }

    def join(int id) {
        def player = Player.findByUser(springSecurityService.currentUser)
        def course = Course.findById(id)
        if (course != null) {
            if (!course.players.contains(player) && course.players.size() < course.maxPlayers) {
                player.addToCourses(course)
                player.save(flush: true)
                flash.message = "Dodano do kursu"
            } else {
                flash.message = "Jesteś na liście lub brak miejsc"
            }
        } else {
            flash.message = "Nie ma takiego kursu"
        }

        redirect(controller: 'player', action: 'showOwnCourses')
    }
}
