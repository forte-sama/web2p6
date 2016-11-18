package web2p6

import org.apache.commons.lang.builder.HashCodeBuilder

class PermisoDepartamento /* implements Serializable */ {
    Usuario usuario
    Departamento departamento
    Boolean activo

    String creadoPor = "nada"
    Date dateCreated
    Date lastUpdated

    static belongsTo = [usuario: Usuario]

    static constraints = {
        creadoPor(blank: false, display: false)
        activo(blank: false)
        usuario(blank: false)
        departamento(blank: false, validator: {val,obj ->
            for(PermisoDepartamento pd in obj.usuario.permisos) {
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
