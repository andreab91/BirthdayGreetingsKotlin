import java.util.*
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

open class Mailer(val smtpHost: String, val smtpPort: Int) {
    open fun sendMessage(sender: String, subject: String, body: String, recipient: String) {
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