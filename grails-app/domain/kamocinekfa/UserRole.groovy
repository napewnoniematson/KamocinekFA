package kamocinekfa

class UserRole {

    String role

    static hasOne = [player: Player, coach: Coach, admin: Admin]
    static mappedBy = [player: 'userRole', coach: 'userRole', admin: 'userRole']

    static constraints = {
    }
}
