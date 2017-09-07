open class BirthdayService(private val employeeRepository: EmployeeRepository, private val mailer: Mailer) {

    fun sendGreetings(xDate: XDate) {
        employeeRepository.bornOn(xDate).forEach { employee ->
            val recipient = employee.email
            val body = "Happy Birthday, dear ${employee.firstName}!"
            val subject = "Happy Birthday!"
            mailer.sendMessage("sender@here.com", subject, body, recipient)
        }
    }

}