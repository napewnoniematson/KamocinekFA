package kamocinekfa

class AccountController {

    def mailService

    def index() { }

    def create() {}

    def save() {
        def user = new User(
                username: params.username,
                password: params.password,
                enabled: false)

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

        if (user.hasErrors() || player.hasErrors()) {
            render(view: 'create', model: [user: user, player: player])
        } else {
            try {
                mailService.sendMail {
                    from("kamocinekfa.noreply@gmail.com")
                    to("kamocinekfa.noreply@gmail.com")
                    subject("Confirm registration")
                    html "Welcome ${player.name} ${player.lastname} in our academy. Please confirm your account</br>" +
                            "<a href=\"https://www.youtube.com/watch?v=y5U-I5wk1uo\""
                }
                player.save(flush: true)
                UserAuthority.create(user, Authority.findByAuthority("ROLE_PLAYER"), true)
            } catch (Exception e) {
                e.printStackTrace()
//moze jakis render do info ze sie nie udalo

            }

            redirect(controller: 'login', action: "auth")
        }
    }
}
