package web2p6

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContactoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contacto.list(params), model:[contactoCount: Contacto.count()]
    }

    def show(Contacto contacto) {
        respond contacto
    }

    def create() {
        respond new Contacto(params)
    }

    @Transactional
    def save(Contacto contacto) {
        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contacto.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contacto.errors, view:'create'
            return
        }

        contacto.creadoPor = session.user.email
        contacto.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect contacto
            }
            '*' { respond contacto, [status: CREATED] }
        }
    }

    def edit(Contacto contacto) {
        respond contacto
    }

    @Transactional
    def update(Contacto contacto) {
        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contacto.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contacto.errors, view:'edit'
            return
        }

        contacto.creadoPor = session.user.email
        contacto.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect contacto
            }
            '*'{ respond contacto, [status: OK] }
        }
    }

    @Transactional
    def delete(Contacto contacto) {

        if (contacto == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        contacto.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contacto.label', default: 'Contacto'), contacto.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contacto.label', default: 'Contacto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def agregar_relacion() {
        render(view: 'agregar_relacion', model:[
                'contactos':Contacto.list(),
                'departamentos':Departamento.list()
        ])
    }

    def formAgregarRelacion() {
        Integer cont_id = Integer.parseInt((String)params.get("contacto"))
        Integer dept_id = Integer.parseInt((String)params.get("departamento"))

        Contacto u = Contacto.findById(cont_id)
        Departamento d = Departamento.findById(dept_id)

        boolean tienePermiso = PermisoDepartamento.countByDepartamentoAndUsuario(d,(Usuario)session.user)

        boolean puedeSeguir = session.user.isAdmin || tienePermiso

        if(puedeSeguir) {
            PertenenciaDepartamento pd = new PertenenciaDepartamento(contacto: u, departamento: d, activo: true)
            pd.creadoPor = session.user.email
            pd.validate()

            if(!pd.hasErrors()) {
                pd.save(flush: true)

                flash.message = "${u.email} fue agregado como contacto en ${d.nombre}."
            }
            else {
                flash.error = "Ya ${u.email} es un contacto de ${d.nombre}. No es posible duplicar."
            }

            redirect(controller: 'contacto', action: 'agregar_relacion')
        }
        else {
            flash.error = "El usuario actual no tiene permiso para ${d.nombre}"
            redirect(controller: 'contacto', action: 'agregar_relacion')
        }
    }
}
