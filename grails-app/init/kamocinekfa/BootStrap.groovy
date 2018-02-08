package kamocinekfa

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Authority(authority: 'ROLE_ADMIN').save()
        def coachRole = new Authority(authority: 'ROLE_COACH').save()
        def playerRole = new Authority(authority: 'ROLE_PLAYER').save()

        def admin = new User(username: 'admin', password: 'admin').save()
        def coach = new User(username: 'coach', password: 'coach').save()
        def player = new User(username: 'player', password: 'player').save()

        UserAuthority.create(admin, adminRole).save(flush: true)
        UserAuthority.create(coach, coachRole).save(flush: true)
        UserAuthority.create(player, playerRole).save(flush: true)

        UserAuthority.withSession {
            it.flush()
            it.clear()
        }

//
//        if (UserRole.count() == 0) {
//            println("------------------------userrole---------------------")
//            new UserRole(role: "Admin").save(failOnError: true)
//            new UserRole(role: "Coach").save()
//            new UserRole(role: "Player").save()
//        }
//
//        if (Course.count() == 0) {
//            println("------------------------Course---------------------")
//            new Course(title: "Dietetyka dla młodych", startDate: "12-05-2018", endDate: "12-05-2018",
//                    maxPlayers: 30)
//                    .save(failOnError: true)
//            new Course(title: "Gra defensywna", startDate: "06-06-2018", endDate: "08-06-2018",
//                    maxPlayers: 22)
//                    .save()
//        }
//
//        if (Coach.count() == 0) {
//            println("------------------------Coachma---------------------")
//            new Coach(name: "Jacek", lastname: "Krzynówek", email: "jk@kfa.com",
//                    userRole: UserRole.findByRole("Coach"))
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save(failOnError: true)
//            new Coach(name: "Maciej", lastname: "Żurawski", email: "mz@kfa.com",
//                    userRole: UserRole.findByRole("Coach"))
//                    .addToCourses(Course.findByTitle("Gra defensywna"))
//                    .save()
//        }
//
//        if (Player.count() == 0) {
//            println("------------------------Player---------------------")
//            new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
//                    , height: 124, weight: 35, userRole: UserRole.findByRole("Player"))
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save(failOnError: true)
//            new Player(name: "Paweł", lastname: "Brożek", email: "pb@kfa.com", birthdate: "24-01-2002"
//                    , height: 164, weight: 55, userRole: UserRole.findByRole("Player"))
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save()
//            new Player(name: "Enzo", lastname: "Rodriguez", email: "er@kfa.com", birthdate: "24-01-2002"
//                    , height: 123, weight: 32, userRole: UserRole.findByRole("Player"))
//                    .addToCourses(Course.findByTitle("Gra defensywna"))
//                    .save(failOnError: true)
//        }
    }
    def destroy = {
    }
}
