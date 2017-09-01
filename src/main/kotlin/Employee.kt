package main

data class Employee(val firstName: String, val lastName: String, var birthDate: String, val email: String) {

    fun isBirthday(today: XDate): Boolean {
        return today.isSameDay(birthDate)
    }
}