import java.io.BufferedReader
import java.io.FileReader

open class EmployeeRepository(private val fileName: String) {

    open fun employees(): List<Employee> {
        val fileBuffer = BufferedReader(FileReader(fileName))

        // skip the first line (header)
        fileBuffer.readLine()

        val employeeList = mutableListOf<Employee>()

        fileBuffer.readLines().forEach {
            val employeeData = it.split(", ")
            employeeList.add(Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]))
        }

        return employeeList
    }
}