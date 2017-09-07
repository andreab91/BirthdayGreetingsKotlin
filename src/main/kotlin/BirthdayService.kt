open class BirthdayService(private val employeeRepository: EmployeeRepository, private val mailer: Mailer) {

    fun sendGreetings(xDate: XDate) {
        employeeRepository.employees().forEach { employee ->
            if(employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear ${employee.firstName}!"
                val subject = "Happy Birthday!"
                mailer.sendMessage("sender@here.com", subject, body, recipient)
            }
        }
    }

}