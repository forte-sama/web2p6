package web2p6

class Departamento {

    String nombre

    static constraints = {
        nombre(blank: false)
    }

    static mapping = {
    }
}
