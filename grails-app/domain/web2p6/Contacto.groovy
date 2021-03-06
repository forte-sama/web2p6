package web2p6

class Contacto {

    String nombre
    String apellido
    String email
    String telefonoMovil
    String direccion
    String ocupacion
    Categoria categoria

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static hasMany = [relaciones: PertenenciaDepartamento]

    static constraints = {
        email(email: true, validator: {val,obj ->
            Contacto c = Contacto.findByEmail(val)

            if(c) {
                String dept = "Ninguno"
                if(c.relaciones) {
                    dept = c.relaciones.head().departamento.nombre
                }
                return ['contacto.email.validator',dept]
            }
            else {
                return true
            }
        })
        telefonoMovil(matches: '8[024]9-[0-9]{3}-[0-9]{4}', validator: {val,obj ->
            Contacto c = Contacto.findByTelefonoMovil(val)

            if(c) {
                String dept = "Ninguno"
                if(c.relaciones && c.relaciones.size() > 0) dept = c.relaciones.head().departamento.nombre
                return ['contacto.telefonoMovil.validator', dept]
            }
            else {
                return true
            }
        })
        nombre(blank: false)
        apellido(blank: false)
        direccion(blank: false)
        ocupacion(blank: false)
        categoria(blank: false)
        creadoPor(blank: false, display: false)
    }

    static mapping = {
    }
}
