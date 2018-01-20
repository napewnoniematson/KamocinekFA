package kamocinekfa

class Player {

    String name
    String lastname




    static hasMany = [courses: Course]
    static mappedBy = [courses: 'players']

    static constraints = {
    }
}
