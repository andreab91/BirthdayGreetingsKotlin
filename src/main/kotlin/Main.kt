fun main(args: Array<String>) {
    val service = BirthdayService(EmployeeRepository("employee_data.txt"), Mailer("localhost", 25))
    service.sendGreetings(XDate(), "localhost", 25)
}