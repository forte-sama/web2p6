package web2p6

class BootStrap {

    def init = { servletContext ->
        Usuario admin = new Usuario()
        admin.setNombre("Admin")
        admin.setApellido("Admin")
        admin.setEmail("admin@admin.com")
        admin.setPassword("admin")
        admin.setTelefono("809-000-0000")
        admin.setIsAdmin(true)

        if(admin.validate()) {
            admin.save(flush: true)
        }
    }
    def destroy = {
    }
}
