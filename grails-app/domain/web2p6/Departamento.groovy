package web2p6

class Departamento {

    String nombre

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static constraints = {
        creadoPor(blank: true, display: false)
        nombre(blank: false, unique: true)
    }

    static mapping = {
    }
}
