package test

import main.Employee
import main.XDate
import org.junit.Test
import org.junit.Assert.*


class EmployeeTest {

    @Test
    @Throws(Exception::class)
    fun testBirthday() {
        val employee = Employee("foo", "bar", "1990/01/31", "a@b.c")
        assertFalse(employee.isBirthday(XDate("2008/01/30")))
        assertTrue(employee.isBirthday(XDate("2008/01/31")))
    }

    @Test
    @Throws(Exception::class)
    fun equality() {
        val base = Employee("First", "Last", "1999/09/01", "first@last.com")
        val same = Employee("First", "Last", "1999/09/01", "first@last.com")
        val different = Employee("First", "Last", "1999/09/01", "boom@boom.com")

        assertFalse(base.equals(""))
        assertTrue(base == same)
        assertFalse(base == different)
    }
}
