package kamocinekfa

class UserRole {

    String role

    static hasMany = [/*players: Player,*/ coachs: Coach, admins: Admin]
    static mappedBy = [/*player: 'userRole',*/ coach: 'userRole', admin: 'userRole']

    static constraints = {
    }
}
