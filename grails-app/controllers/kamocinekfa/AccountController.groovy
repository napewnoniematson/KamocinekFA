package kamocinekfa

class AccountController {

    def mailService
    def recaptchaService

    def index() { }

    def create() {}

    def save() {
        def user = new User(
                username: params.username,
                password: params.password,
                /*enabled: false*/)

        def player = new Player(
                name: params.name,
                lastname: params.lastname,
                email: params.email,
                birthdate: params.birthdate,
                height: params.height,
                weight: params.weight,
                user: user)

        user.validate()
        player.validate()
        def recaptchaOK = true
        if (!recaptchaService.verifyAnswer(session, request.getRemoteAddr(), params)) {
            recaptchaOK = false
        }

        if (user.hasErrors() || player.hasErrors() || !recaptchaOK) {
            render(view: 'create', model: [user: user, player: player])
        } else {
            try {
                player.save(flush: true)
                UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
                mailService.sendMail {
                    from("kamocinekfa.noreply@gmail.com")
                    to("kamocinekfa.noreply@gmail.com")
                    subject("Successful registration")
                    html "Welcome ${player.name} ${player.lastname} in our academy. Your account was created"
                }
                recaptchaService.cleanUp(session)
            } catch (Exception e) {
                e.printStackTrace()
            }
            redirect(controller: 'login', action: "auth")
        }
    }
}
