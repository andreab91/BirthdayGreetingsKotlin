package main

import java.io.BufferedReader
import java.io.FileReader
import java.util.*
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class BirthdayService {

    fun sendGreetings(fileName: String, xDate: XDate, smtpHost: String, smtpPort: Int) {
        val input = BufferedReader(FileReader(fileName))
        // skip the first line (header)
        input.readLine()

        input.readLines().forEach {
            val employeeData = it.split(", ")
            val employee = Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3])
            if(employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear ${employee.firstName}!"
                val subject = "Happy Birthday!"
                sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient)
            }
        }
    }

    private fun sendMessage(smtpHost: String, smtpPort: Int, sender: String, subject: String, body: String, recipient: String) {
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
