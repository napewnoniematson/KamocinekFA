package kamocinekfa

class Course {

    String title
    String startDate
    String endDate
    //String addres
    Integer maxPlayers

    Coach coach
    static hasMany = [players: Player]
    static mappedBy = [players: 'courses']

    static constraints = {
        title size: 2..25, blank: false
        maxPlayers min: 10
        players nullable: true
        coach nullable: true
    }
}
