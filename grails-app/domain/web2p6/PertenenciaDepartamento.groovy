package web2p6

class PertenenciaDepartamento implements Serializable {

    Contacto contacto
    Departamento departamento

    static constraints = {
        departamento(blank: false, validator: {val,obj ->
            for(PertenenciaDepartamento pd in obj.contacto.relaciones) {
                if(pd.departamento.id == val.id) {
                    return false
                }
            }

            return true
        })
    }

    static mapping = {
    }
}
