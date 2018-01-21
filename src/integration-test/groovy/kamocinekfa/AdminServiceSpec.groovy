package kamocinekfa

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdminServiceSpec extends Specification {

    AdminService adminService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Admin(...).save(flush: true, failOnError: true)
        //new Admin(...).save(flush: true, failOnError: true)
        //Admin admin = new Admin(...).save(flush: true, failOnError: true)
        //new Admin(...).save(flush: true, failOnError: true)
        //new Admin(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //admin.id
    }

    void "test get"() {
        setupData()

        expect:
        adminService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Admin> adminList = adminService.list(max: 2, offset: 2)

        then:
        adminList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        adminService.count() == 5
    }

    void "test delete"() {
        Long adminId = setupData()

        expect:
        adminService.count() == 5

        when:
        adminService.delete(adminId)
        sessionFactory.currentSession.flush()

        then:
        adminService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Admin admin = new Admin()
        adminService.save(admin)

        then:
        admin.id != null
    }
}
