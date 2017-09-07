fun main(args: Array<String>) {
    val service = BirthdayService(EmployeeRepository("employee_data.txt"))
    service.sendGreetings(XDate(), "localhost", 25)
}