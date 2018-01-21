package kamocinekfa

class Course {

    String title
    String startDate
    String endDate
    //String addres
    Integer maxPlayers

    Coach coach
    static hasMany = [players: Player]
    static belongsTo = [coach: Coach, players:  Player]
//    static mapping = {
//        players cascade: 'save-update'
//    }

    static constraints = {
        title size: 2..25, blank: false
        maxPlayers min: 10
    }
}
