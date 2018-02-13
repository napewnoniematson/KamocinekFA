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
                    subject("Successful registration")
                    html "Welcome ${player.name} ${player.lastname} in our academy. Your account was created"
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
