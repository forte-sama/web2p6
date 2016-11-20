package web2p6


class AdminOnlyInterceptor {

    AdminOnlyInterceptor() {
        match(controller: 'usuario')
        match(controller: 'contacto')
        match(controller: 'categoria')
        match(controller: 'departamento')
    }

    boolean before() {
        Usuario u = (Usuario)session.user

        boolean valid = true

        if(u) {
            if(u.isAdmin) {
                return true
            }
            else {
                switch(params.controller) {
                    case 'usuario':
                        valid = false
                        break
                    case 'contacto':
                        return true
                        break
                    case 'categoria':
                        valid = params.action == 'grafico'
                        break
                    case 'departamento':
                        valid = params.action in ['grafico','lista_contactos']
                        break
                }
            }
        }
        else {
            valid = false
        }

        if(!valid) {
            flash.redirectNoUserMessage = "true"
            redirect(url: '/')
        }
        else {
            return valid
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
        true
    }
}
