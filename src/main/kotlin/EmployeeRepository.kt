import java.io.BufferedReader
import java.io.FileReader

class EmployeeRepository {
    fun employees(fileName: String): List<Employee> {
        val input = BufferedReader(FileReader(fileName))
        // skip the first line (header)
        input.readLine()

        val employeeList = mutableListOf<Employee>()

        input.readLines().forEach {
            val employeeData = it.split(", ")
            employeeList.add(Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]))
        }

        return employeeList
    }
}