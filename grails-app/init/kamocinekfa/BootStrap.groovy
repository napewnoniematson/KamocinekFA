package kamocinekfa

class BootStrap {

    def init = { servletContext ->


        if (UserRole.count() == 0) {
            println("------------------------userrole---------------------")
            new UserRole(role: "Admin").save(failOnError: true)
            new UserRole(role: "Coach").save()
            new UserRole(role: "Player").save()
        }

        if (Coach.count() == 0) {
            println("------------------------Coachma---------------------")
            new Coach(name: "Jacek", lastname: "Krzynówek", email: "jk@kfa.com",
                    userRole: UserRole.findByRole("Coach")).save(failOnError: true)
            new Coach(name: "Maciej", lastname: "Żurawski", email: "mz@kfa.com",
                    userRole: UserRole.findByRole("Coach")).save()
        }

        if (Course.count() == 0) {
            println("------------------------Course---------------------")
            new Course(title: "Dietetyka dla młodych", startDate: "12-05-2018", endDate: "12-05-2018",
                    maxPlayers: 30, coach: Coach.findByEmail("jk@kfa.com")).save(failOnError: true)
            new Course(title: "Gra defensywna", startDate: "06-06-2018", endDate: "08-06-2018",
                    maxPlayers: 22, coach: Coach.findByEmail("mz@kfa.com")).save()
        }

        if (Player.count() == 0) {
            println("------------------------Player---------------------")
            new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
                    , height: 124, weight: 35, userRole: UserRole.findByRole("Player")
                    , courses: Course.findByTitle("Dietetyka dla młodych")).save(failOnError: true)
            new Player(name: "Paweł", lastname: "Brożek", email: "pb@kfa.com", birthdate: "24-01-2002"
                    , height: 164, weight: 55, userRole: UserRole.findByRole("Player")
                    , courses: Course.findByTitle("Dietetyka dla młodych")).save()
            new Player(name: "Enzo", lastname: "Rodriguez", email: "er@kfa.com", birthdate: "24-01-2002"
                    , height: 123, weight: 32, userRole: UserRole.findByRole("Player")
                    , courses: Course.findByTitle("Gra defensywna")).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
