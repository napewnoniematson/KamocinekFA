package kamocinekfa

class BootStrap {

    def init = { servletContext ->

        println ("Coaches" + Coach.count())

        if (Coach.count() == 0) {
            new Coach(name: "Jacek", lastname: "Krzynówek", email: "jk@kfa.com").save()
            new Coach(name: "Maciej", lastname: "Żurawski", email: "mz@kfa.com").save()
        }

        if (Player.count() == 0) {
            new Player(name: "Jan", lastname: "Nowak", email: "jo@kfa.com", birthdate: "12-05-2008"
                    , height: 124, weight: 35).save()
            new Player(name: "Paweł", lastname: "Brożek", email: "pb@kfa.com", birthdate: "24-01-2002"
                    , height: 164, weight: 55).save()
        }

        if (Course.count() == 0) {
            new Course(title: "Dietetyka dla młodych", startDate: "12-05-2018", endDate: "12-05-2018",
                    maxPlayers: 30, coach: Coach.findByEmail("jk@kfa.com"),
                    players: Player.findByEmail("jo@kfa.com")).save()
            new Course(title: "Gra defensywna", startDate: "06-06-2018", endDate: "08-06-2018",
                    maxPlayers: 22, coach: Coach.findByEmail("mz@kfa.com"),
                    players: Player.findByEmail("pb@kfa.com")).save()
        }

    }
    def destroy = {
    }
}
