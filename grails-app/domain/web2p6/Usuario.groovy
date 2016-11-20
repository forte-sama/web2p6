package web2p6

class Usuario {

    String email
    String password
    String nombre
    String apellido
    String telefono
    Boolean isAdmin

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static hasMany = [permisos: PermisoDepartamento]

    static constraints = {
        email(unique: true,email: true, blank: false)
        password(size: 5..20)
        nombre(blank: false)
        apellido(blank: false)
        telefono(matches: '8[024]9-[0-9]{3}-[0-9]{4}')
        creadoPor(nullable: true, blank: true, display: false)
    }

    static mapping = {
    }

//    def beforeInsert() {
//        if(isAdmin) {
//            creadoPor = "_"
//        }
//        else {
//            if (session.user) {
//                creadoPor = session.user.email
//            } else {
//                creadoPor = "default"
//            }
//        }
//    }
}
