import main.BirthdayService
import main.Employee
import main.XDate
import org.junit.Assert.*
import org.junit.Test

class BirthdayServiceTest {
    @Test
    fun does_not_send_messages_if_there_are_no_birthdays() {
        val birthdayService = TestableBirthdayService()

        birthdayService.sendGreetings("aFileName", XDate("1789/02/25"), "localhost", 1234)

        assertEquals(false, birthdayService.called)
    }
}

class TestableBirthdayService : BirthdayService() {

    var called = false

    override fun employees(fileName: String) : List<Employee> {
        return listOf(Employee("first_name", "last_name", "1999/09/01", "e@mail.com"))
    }

    override fun sendMessage(smtpHost: String, smtpPort: Int, sender: String, subject: String, body: String, recipient: String) {
        called = true
    }
}
