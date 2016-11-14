package web2p6

import grails.test.mixin.*
import spock.lang.*

@TestFor(PertenenciaDepartamentoController)
@Mock(PertenenciaDepartamento)
class PertenenciaDepartamentoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.pertenenciaDepartamentoList
            model.pertenenciaDepartamentoCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.pertenenciaDepartamento!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def pertenenciaDepartamento = new PertenenciaDepartamento()
            pertenenciaDepartamento.validate()
            controller.save(pertenenciaDepartamento)

        then:"The create view is rendered again with the correct model"
            model.pertenenciaDepartamento!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            pertenenciaDepartamento = new PertenenciaDepartamento(params)

            controller.save(pertenenciaDepartamento)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/pertenenciaDepartamento/show/1'
            controller.flash.message != null
            PertenenciaDepartamento.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def pertenenciaDepartamento = new PertenenciaDepartamento(params)
            controller.show(pertenenciaDepartamento)

        then:"A model is populated containing the domain instance"
            model.pertenenciaDepartamento == pertenenciaDepartamento
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def pertenenciaDepartamento = new PertenenciaDepartamento(params)
            controller.edit(pertenenciaDepartamento)

        then:"A model is populated containing the domain instance"
            model.pertenenciaDepartamento == pertenenciaDepartamento
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/pertenenciaDepartamento/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def pertenenciaDepartamento = new PertenenciaDepartamento()
            pertenenciaDepartamento.validate()
            controller.update(pertenenciaDepartamento)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.pertenenciaDepartamento == pertenenciaDepartamento

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            pertenenciaDepartamento = new PertenenciaDepartamento(params).save(flush: true)
            controller.update(pertenenciaDepartamento)

        then:"A redirect is issued to the show action"
            pertenenciaDepartamento != null
            response.redirectedUrl == "/pertenenciaDepartamento/show/$pertenenciaDepartamento.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/pertenenciaDepartamento/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def pertenenciaDepartamento = new PertenenciaDepartamento(params).save(flush: true)

        then:"It exists"
            PertenenciaDepartamento.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(pertenenciaDepartamento)

        then:"The instance is deleted"
            PertenenciaDepartamento.count() == 0
            response.redirectedUrl == '/pertenenciaDepartamento/index'
            flash.message != null
    }
}
