package web2p6

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Categoria.list(params), model:[categoriaCount: Categoria.count()]
    }

    def show(Categoria categoria) {
        respond categoria
    }

    def create() {
        respond new Categoria(params)
    }

    @Transactional
    def save(Categoria categoria) {
        if (categoria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoria.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoria.errors, view:'create'
            return
        }

        categoria.creadoPor = session.user.email
        categoria.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoria.id])
                redirect categoria
            }
            '*' { respond categoria, [status: CREATED] }
        }
    }

    def edit(Categoria categoria) {
        respond categoria
    }

    @Transactional
    def update(Categoria categoria) {
        if (categoria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoria.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoria.errors, view:'edit'
            return
        }

        categoria.creadoPor = session.user.email
        categoria.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoria.id])
                redirect categoria
            }
            '*'{ respond categoria, [status: OK] }
        }
    }

    @Transactional
    def delete(Categoria categoria) {

        if (categoria == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        categoria.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoria.label', default: 'Categoria'), categoria.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoria.label', default: 'Categoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def grafico = {
        List col  = [['string', 'Categoria'], ['number', 'Cantidad de Contactos']]
        List data = []

        def res = Categoria.findAll()

        for(Categoria d in res) {
            data << [d.nombre, Contacto.countByCategoria(d)]
        }

        render (view: 'grafico', model: ["col": col,
                                         "data": data])
    }
}
