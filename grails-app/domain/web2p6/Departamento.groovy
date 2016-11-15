package web2p6

class Departamento {

    String nombre

    static constraints = {
        nombre(blank: false, unique: true)
    }

    static mapping = {
    }
}
