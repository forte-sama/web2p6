package web2p6

class Contacto {

    String nombre
    String apellido
    String email
    String telefonoMovil
    String direccion
    String ocupacion
    Categoria categoria

    String creadoPor
    Date dateCreated
    Date lastUpdated

    static hasMany = [relaciones: PertenenciaDepartamento]

    static constraints = {
        creadoPor(blank: false, display: false)
        email(email: true, validator: {val,obj ->
            Contacto c = Contacto.findByEmail(val)

            if(c) {
                String dept = c.relaciones.size() > 0 ? c.relaciones.head().departamento.nombre : 'Ninguno'
                return ['contacto.email.validator',dept]
            }
            else {
                return true
            }
        })
        telefonoMovil(matches: '8[024]9-[0-9]{3}-[0-9]{4}', validator: {val,obj ->
            Contacto c = Contacto.findByTelefonoMovil(val)

            if(c) {
                String dept = c.relaciones.size() > 0 ? c.relaciones.head().departamento.nombre : 'Ninguno'
                return ['contacto.telefonoMovil.validator',dept]
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

    }

    static mapping = {
    }
}
