package web2p6


class AdminOnlyInterceptor {

    AdminOnlyInterceptor() {
        match(controller: 'usuario')
        match(controller: 'categoria')
        match(controller: 'departamento')
    }

    boolean before() {
        Usuario u = (Usuario)session.user

        if(u && u.isAdmin) {
            return true
        }
        else {
            redirect(url: '/')
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
        true
    }
}
