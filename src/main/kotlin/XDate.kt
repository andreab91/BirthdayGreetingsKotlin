import java.text.SimpleDateFormat
import java.util.*

class XDate() {
    private var date: Date

    init {
        this.date = Date()
    }

    constructor(yyyyMMdd: String): this() {
        this.date = SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd)
    }

    fun getDay() = getPartOfDate(GregorianCalendar.DAY_OF_MONTH)

    fun getMonth() = 1 + getPartOfDate(GregorianCalendar.MONTH)

    fun isSameDay(anotherDate: XDate): Boolean {
        return anotherDate.getDay() == this.getDay() &&
                anotherDate.getMonth() == this.getMonth()
    }

    fun isSameDay(anotherDate: String) = isSameDay(XDate(anotherDate))

    override fun hashCode() = date.hashCode()

    override fun equals(other: Any?): Boolean {
        if (!(other is XDate))
            return false
        // uses "smart cast" => no need for explicit cast to XDate
        return other.date == this.date
    }

    private fun  getPartOfDate(part: Int): Int {
        val calendar = GregorianCalendar()
        calendar.time = date
        return calendar.get(part)
    }
}