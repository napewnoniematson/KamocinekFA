import grails.plugin.springsecurity.SpringSecurityService
import kamocinekfa.AdminController
import kamocinekfa.CoachController
import kamocinekfa.PlayerController
import kamocinekfa.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    player(PlayerController){
        springSecurityService = ref('springSecurityService')
    }

    coach(CoachController){
        springSecurityService = ref('springSecurityService')
    }

    admin(AdminController){
        springSecurityService = ref('springSecurityService')
    }


}
