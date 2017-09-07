fun main(args: Array<String>) {
    val service = BirthdayService(EmployeeRepository("employee_data.txt"))
    service.sendGreetings("employee_data.txt", XDate(), "localhost", 25)
}