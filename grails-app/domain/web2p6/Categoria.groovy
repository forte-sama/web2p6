package web2p6

class Categoria {

    String nombre

    String creadoPor
    Date dateCreated
    Date lastUpdated

    static constraints = {
        creadoPor(blank: false, display: false)
        nombre(blank: false, unique: true)
    }

    static mapping = {
    }

    def beforeInsert() {
        creadoPor = session.user.email
    }
}
