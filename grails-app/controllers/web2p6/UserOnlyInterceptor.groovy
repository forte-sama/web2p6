package web2p6


class UserOnlyInterceptor {

    UserOnlyInterceptor() {
        match(controller: 'contacto')
    }

    boolean before() {
        if(session.user) {
            return true
        }
        else {
            redirect(url: '/')
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
