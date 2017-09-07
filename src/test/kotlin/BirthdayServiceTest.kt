import org.junit.Assert.*
import org.junit.Test

class BirthdayServiceTest {
    @Test
    fun does_not_send_messages_if_there_are_no_birthdays() {
        val spyMailer = SpyMailer()
        val birthdayService = BirthdayService(FakeEmployeeRepository(), spyMailer)

        birthdayService.sendGreetings(XDate("1789/02/25"))

        assertEquals(false, spyMailer.isCalled())
    }

    @Test
    fun sends_message_when_there_is_a_birthday() {
        val spyMailer = SpyMailer()
        val birthdayService = BirthdayService(FakeEmployeeRepository(), spyMailer)

        birthdayService.sendGreetings(XDate("1999/09/01"))

        assertEquals(true, spyMailer.isCalled())
    }
}

class FakeEmployeeRepository : EmployeeRepository("aFileName") {

    override fun employees(): List<Employee> {
        return listOf(Employee("first_name", "last_name", "1999/09/01", "e@mail.com"))
    }
}

class SpyMailer : Mailer("localhost", 25) {
    var called = false

    override fun sendMessage(sender: String, subject: String, body: String, recipient: String) {
        called = true
    }

    fun isCalled() = called
}
