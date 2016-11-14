package web2p6

class SiteController {

    def index() {
        redirect(controller: 'site', action: 'login')
    }

    def login() {
        if(session.user) {
            redirect(url: '/')
        }
        else {
            render(controller: 'site', view: 'login')
        }
    }

    def logout() {
        session.invalidate()

        redirect(uri: request.getHeader('referer'))
    }

    def processLogin() {
        Boolean success = false
        String email = (String)params.get('email')
        String passw = (String)params.get('password')

        Usuario u = Usuario.findByEmail(email)

        if(u) {
            if (u.password == passw) {
                session['user'] = u
                success = true
            }
        }

        if(success) {
            redirect(controller: 'usuario', action: 'index')
        }
        else {
            redirect(controller: 'site', action: 'login')
        }
    }
}
