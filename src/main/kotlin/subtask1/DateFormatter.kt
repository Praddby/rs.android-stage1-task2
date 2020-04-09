package subtask1

import java.time.DateTimeException
import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val numberDayOfWeek = toTextDayOfWeek(day.toInt(), month.toInt(), year.toInt())
            "$day ${nameMonth[month]}, ${dayOfWeek[numberDayOfWeek]}"
        } catch(e: DateTimeException){
            "Такого дня не существует"
        }
    }

    private val dayOfWeek = mapOf(
        0 to "понедельник", 1 to "вторник", 2 to "среда",
        3 to "четверг", 4 to "пятница", 5 to "суббота", 6 to "воскресенье")

    private val nameMonth = mapOf(
        "1" to "января", "2" to "февраля", "3" to "марта",
        "4" to "апреля", "5" to "мая", "6" to "июня",
        "7" to "июля", "8" to "августа", "9" to "сентября",
        "10" to "октября", "11" to "ноября", "12" to "декабря")

    private fun toTextDayOfWeek(day: Int, month: Int, year: Int): Int? {
        val date: LocalDate? = LocalDate.of(year, month, day)
        return date?.dayOfWeek?.ordinal
    }
}

