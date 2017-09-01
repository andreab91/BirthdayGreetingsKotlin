package test

import main.XDate
import org.junit.Test
import org.junit.Assert.*

class XDateTest {

    @Test
    @Throws(Exception::class)
    fun getters() {
        val date = XDate("1789/01/24")
        assertEquals(1, date.getMonth())
        assertEquals(24, date.getDay())
    }

    @Test
    @Throws(Exception::class)
    fun isSameDate() {
        val date = XDate("1789/01/24")
        val sameDay = XDate("2001/01/24")
        val notSameDay = XDate("1789/01/25")
        val notSameMonth = XDate("1789/02/25")

        assertTrue(date.isSameDay(sameDay))
        assertFalse(date.isSameDay(notSameDay))
        assertFalse(date.isSameDay(notSameMonth))
    }

    @Test
    @Throws(Exception::class)
    fun equality() {
        val base = XDate("2000/01/02")
        val same = XDate("2000/01/02")
        val different = XDate("2000/01/04")

        assertFalse(base.equals(""))
        assertTrue(base == base)
        assertTrue(base == same)
        assertFalse(base == different)
    }
}