package kamocinekfa

class Course {

    String title
    String startDate
    String endDate
    String addres
    Integer maxPlayers

    Coach coach
    static belongsTo = [coach: Coach]

    static hasMany = [players: Player]

    static constraints = {
        title size: 2..25, blank: false
        maxPlayers min: 10
    }
}