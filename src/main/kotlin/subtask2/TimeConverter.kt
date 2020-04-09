package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        return when (val min = minute.toInt()) {
            0 -> "${numberToWords(hour.toInt())} o' clock"
            30 -> "half past ${numberToWords(hour.toInt())}"
            15 -> "quarter past ${numberToWords(hour.toInt())}"
            45 -> "quarter to ${numberToWords(hour.toInt()+1)}"
            in 1..29 -> "${numberToWords(min)} minutes past ${numberToWords(hour.toInt())}"
            in 31..59 -> "${numberToWords(60-min)} minutes to ${numberToWords(hour.toInt()+1)}"
            else -> ""
        }
    }

    private val dig1 = arrayOf(
        "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine")

    private val dig10 = arrayOf(
        "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    private val dig20 = arrayOf(
        "twenty", "thirty", "forty", "fifty")

    private fun numberToWords(num: Int): String {
        val words = StringBuilder(50)
        val d = num / 10
        val n = num % 10
        when (d) {
            0 -> {}
            1 -> words.append(dig10[n]).append(" ")
            else -> words.append(dig20[d - 2]).append(" ")
        }
        if (d != 1 && n != 0) {
            words.append(dig1[n - 1]).append(" ")
        }
        return words.toString().trim()
    }
}
