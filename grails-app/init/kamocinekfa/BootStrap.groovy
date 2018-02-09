package kamocinekfa

class BootStrap {

    def init = { servletContext ->



//
////        def admin = new User(username: 'admin', password: 'admin',dupa: 1).save(failsOnError: true)
////        def coach = new User(username: 'coach', password: 'coach',dupa: 1).save()
//        def playerU = new User(username: 'player', password: 'player')
//        def player = new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
//                    , height: 124, weight: 35, user: playerU)
//
//
//
//
//
////        UserAuthority.create(admin, adminRole, true)
////        UserAuthority.create(coach, coachRole, true)
//        playerU.save(failOnError: true, flush:true)
//        player.save(failOnError: true, flush:true)
//        UserAuthority.create(playerU, playerRole, true)
//        println "User.findByUsername(\"player\"): "+ User.findByUsername("player")?.player.name

//            println("------------------------Player---------------------")
//            new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
//                    , height: 124, weight: 35, user: player)
//                    .save(failOnError: true, flush:true)
//
//




//        if (UserRole.count() == 0) {
//            println("------------------------userrole---------------------")
////            new UserRole(role: "Admin").save(failOnError: true)
////            new UserRole(role: "Coach").save()
////            new UserRole(role: "Player").save()
//            def adminRole = new Authority(authority: 'ROLE_ADMIN').save(failsOnError: true)
//            def coachRole = new Authority(authority: 'ROLE_COACH').save()
//            def playerRole = new Authority(authority: 'ROLE_PLAYER').save()
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
//            println("------------------------Coach-----------------------")
//
//            def user = new User(username: "jk", password: "jk")
//            def coach = new Coach(name: "Jacek", lastname: "Krzynówek", email: "jk@kfa.com", user: user)
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save(failOnError: true)
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_COACH"), true)
//            user = new User(username: "mz", password: "mz")
//            coach = new Coach(name: "Maciej", lastname: "Żurawski", email: "mz@kfa.com", user: user)
//                    .addToCourses(Course.findByTitle("Gra defensywna"))
//                    .save()
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_COACH"), true)
//
//        }
//
//        if (Player.count() == 0) {
//            println("------------------------Player---------------------")
//            def user = new User(username: "jn", password: "jn")
//            new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
//                    , height: 124, weight: 35, user: user)
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save(failOnError: true)
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
//            user = new User(username: "pb", password: "pb", enabled: false)
//            new Player(name: "Paweł", lastname: "Brożek", email: "pb@kfa.com", birthdate: "24-01-2002"
//                    , height: 164, weight: 55, user: user)
//                    .addToCourses(Course.findByTitle("Dietetyka dla młodych"))
//                    .save()
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
//            user = new User(username: "er", password: "er", accountExpired: true)
//            new Player(name: "Enzo", lastname: "Rodriguez", email: "er@kfa.com", birthdate: "24-01-2002"
//                    , height: 123, weight: 32, user: user)
//                    .addToCourses(Course.findByTitle("Gra defensywna"))
//                    .save(failOnError: true)
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
//        }
//
//
//        if (Admin.count() == 0) {
//            def user = new User(username: "admin", password: "admin")
//            new Admin(name: "Adaś", lastname: "Adamek", email: "aa@kfa.com", user: user).save(flush: true)
//            UserAuthority.create(user, Authority.findByAuthority("ROLE_ADMIN"), true)
//        }

    }
    def destroy = {
    }
}
