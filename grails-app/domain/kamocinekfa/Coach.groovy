package kamocinekfa

class Coach {

    String name
    String lastname

    static hasMany = [courses: Course]
    static mappedBy = [courses: 'coach']


    static constraints = {
    }
}
