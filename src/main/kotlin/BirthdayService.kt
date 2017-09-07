open class BirthdayService(private val employeeRepository: EmployeeRepository, val mailer: Mailer) {

    fun sendGreetings(xDate: XDate, smtpHost: String, smtpPort: Int) {
        employeeRepository.employees().forEach { employee ->
            if(employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear ${employee.firstName}!"
                val subject = "Happy Birthday!"
                sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient)
            }
        }
    }

    protected open fun sendMessage(smtpHost: String, smtpPort: Int, sender: String, subject: String, body: String, recipient: String) {
        mailer.sendMessage(sender, subject, body, recipient)
    }
}