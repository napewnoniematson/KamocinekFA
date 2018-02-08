package kamocinekfa

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
//    static hasMany = [players: Player, coachs: Coach, admins: Admin]
//    static mappedBy = [player: 'userRole', coach: 'userRole', admin: 'userRole']
//    Coach coach
//    Player player
//    Admin admin
//    static hasOne = [player: Player, coach: Coach, admin: Admin]
//    static mappedBy = [player: 'user', coach: 'user', admin: 'user']
//    static belongsTo = [player: Player, coach: Coach, admin: Admin]


    Set<Authority> getAuthorities() {
        (UserAuthority.findAllByUser(this) as List<UserAuthority>)*.authority as Set<Authority>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
