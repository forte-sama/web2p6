package web2p6


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AdminOnlyInterceptor)
class AdminOnlyInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test adminOnly interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"adminOnly")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
