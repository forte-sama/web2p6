package web2p6

class Contacto {

    String nombre
    String apellido
    String email
    String telefono
    String direccion
    String ocupacion
    String telefonoMovil
    Categoria categoria

    static hasMany = [relaciones: PertenenciaDepartamento]

    static constraints = {
        email(email: true)
        nombre(blank: false)
        apellido(blank: false)
        direccion(blank: false)
        ocupacion(blank: false)
        categoria(blank: false)
        telefono(matches: '8[024]9-[0-9]{3}-[0-9]{4}')
        telefonoMovil(matches: '8[024]9-[0-9]{3}-[0-9]{4}')
    }

    static mapping = {
    }
}
