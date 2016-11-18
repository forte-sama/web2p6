package web2p6


class UserOnlyInterceptor {

    UserOnlyInterceptor() {
        match(controller: 'contacto')
        match(controller: 'departamento')
    }

    boolean before() {

        //si es el controlador de contacto, solo verificar si esta loggeado
        if(params.controller == 'contacto') {
            if(session.user) {
                return true
            }
            else {
                flash.redirectNoUserMessage = "true"
                redirect(url: '/')
            }
        }
        else {
            if (session.user) {

                if(session.user.isAdmin) return true

                //si esta loggeado y se esta manejando un id
                //ver si el usuario tiene permiso en ese departamento
                if(params.id) {
                    Departamento d = Departamento.findById(params.id)

                    if (PermisoDepartamento.findByDepartamentoAndUsuario(d, session.user)) {
                        return true
                    } else {
                        flash.redirectNoUserMessage = "true"
                        redirect(url: '/')
                    }
                }
                //si esta loggeado y no se esta bregando con un id, dar luz verde
                else {
                    return true
                }
            }
            else {
                flash.redirectNoUserMessage = "true"
                redirect(url: '/')
            }
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
