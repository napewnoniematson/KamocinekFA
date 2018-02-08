package kamocinekfa

import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class LoginController extends grails.plugin.springsecurity.LoginController {

//    def auth() {
//
//        def conf = getConf()
//
//        if (springSecurityService.isLoggedIn()) {
//            redirect uri: conf.successHandler.defaultTargetUrl
//            return
//        }
//
//        Collections.shuffle(coordinatePositions)
//        def position = coordinatePositions.first()
//
//        String postUrl = request.contextPath + conf.apf.filterProcessesUrl
//        render view: 'auth', model: [postUrl: postUrl,
//                                     rememberMeParameter: conf.rememberMe.parameter,
//                                     usernameParameter: conf.apf.usernameParameter,
//                                     passwordParameter: conf.apf.passwordParameter,
//                                     gspLayout: conf.gsp.layoutAuth,
//                                     position: position]
//    }


}
