package web2p6

class Departamento {

    String nombre

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static constraints = {
        nombre(blank: false, unique: true)
        creadoPor(blank: true, display: false)
    }

    static mapping = {
    }
}
