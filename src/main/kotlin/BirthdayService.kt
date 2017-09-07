import java.util.*
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

open class BirthdayService {

    fun sendGreetings(fileName: String, xDate: XDate, smtpHost: String, smtpPort: Int) {
        employees(fileName).forEach { employee ->
            if(employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear ${employee.firstName}!"
                val subject = "Happy Birthday!"
                sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient)
            }
        }
    }

    protected open fun employees(fileName: String) : List<Employee> {
        return EmployeeRepository().employees(fileName)
    }

    protected open fun sendMessage(smtpHost: String, smtpPort: Int, sender: String, subject: String, body: String, recipient: String) {
        val props = Properties()
        props.put("mail.smtp.host", smtpHost)
        props.put("mail.smtp.port", smtpPort.toString())
        val session = Session.getInstance(props, null)

        val msg = MimeMessage(session)
        msg.setFrom(InternetAddress(sender))
        msg.setRecipient(Message.RecipientType.TO, InternetAddress(recipient))
        msg.subject = subject
        msg.setText(body)

        Transport.send(msg)
    }

}

