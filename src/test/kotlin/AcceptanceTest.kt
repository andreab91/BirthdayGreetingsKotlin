import org.junit.Test
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import com.dumbster.smtp.SmtpMessage
import com.dumbster.smtp.SimpleSmtpServer

class AcceptanceTest {
    lateinit private var birthdayService: BirthdayService
    lateinit private var mailServer: SimpleSmtpServer
    private val NONSTANDARD_PORT = 9998

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT)
        birthdayService = BirthdayService(EmployeeRepository("employee_data.txt"))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mailServer.stop()
        Thread.sleep(200)
    }

    @Test
    @Throws(Exception::class)
    fun willSendGreetings_whenItsSomebodysBirthday() {
        birthdayService.sendGreetings(XDate("2008/10/08"), "localhost", NONSTANDARD_PORT)

        val message = mailServer.receivedEmail.next() as SmtpMessage
        val recipients = message.getHeaderValues("To")

        assertEquals(1, mailServer.receivedEmailSize)
        assertEquals("Happy Birthday, dear John!", message.body)
        assertEquals("Happy Birthday!", message.getHeaderValue("Subject"))
        assertEquals(1, recipients.size)
        assertEquals("john.doe@foobar.com", recipients[0].toString())
    }

    @Test
    @Throws(Exception::class)
    fun willNotSendEmailsWhenNobodysBirthday() {
        birthdayService.sendGreetings(XDate("2008/01/01"), "localhost", NONSTANDARD_PORT)

        assertEquals(0, mailServer.receivedEmailSize)
    }
}
