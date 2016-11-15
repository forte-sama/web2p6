package web2p6

class Categoria {

    String nombre

    static constraints = {
        nombre(blank: false, unique: true)
    }

    static mapping = {
    }
}
