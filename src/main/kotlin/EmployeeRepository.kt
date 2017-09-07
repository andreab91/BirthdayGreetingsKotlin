import java.io.BufferedReader
import java.io.FileReader

class EmployeeRepository(fileName: String) {
    private val fileBuffer: BufferedReader = BufferedReader(FileReader(fileName))

    fun employees(): List<Employee> {
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