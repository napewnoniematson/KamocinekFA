package kamocinekfa

class Player {

    String name
    String lastname
    String email
    String birthdate
    //String position //posiotion klasa
    Integer height
    Integer weight
    User user

//    UserRole userRole
    static hasMany = [courses: Course]
    static belongsTo = [courses: Course]

    static constraints = {
        name size: 2..15, blank: false
        lastname size: 2..25, blank: false
        email email: true, /* unique: true,*/  blank: false
        birthdate blank: false
        height blank: false
        weight blank: false
        courses nullable: true
    }
}
