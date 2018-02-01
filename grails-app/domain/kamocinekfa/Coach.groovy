package kamocinekfa

class Coach {

    String name
    String lastname
    String email

    UserRole userRole
    static hasMany = [courses: Course]
    static mappedBy = [courses: 'coach']

    static constraints = {
        name size: 2..15, blank: false
        lastname size: 2..25, blank: false
        email email: true,/* unique: true,*/ blank: false
        courses nullable: true
    }
}
