fun main(args: Array<String>) {
    val service = BirthdayService()
    service.sendGreetings("employee_data.txt", XDate(), "localhost", 25)
}