package web2p6

class PertenenciaDepartamento implements Serializable {

    Contacto contacto
    Departamento departamento

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static constraints = {
        creadoPor(blank: false, display: false)
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
