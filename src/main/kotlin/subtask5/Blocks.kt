package subtask5

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> getSumString(blockA)
            Int::class -> getSumInt(blockA)
            LocalDate::class -> getLatestDate(blockA)
            else -> throw NotImplementedError("Not implemented")
        }
    }

    private fun getLatestDate(blockA: Array<*>): Any {
        val now = LocalDate.now()
        var resultDate: Period = Period.ZERO
        for (n in blockA) {
            if (n is LocalDate) {
                val period = Period.between(n, now)
                if (resultDate.isZero) {
                    resultDate = period
                    continue
                }
                if (period.minus(resultDate).isNegative)
                    resultDate = period
            }
        }
        return now.minus(resultDate).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }

    private fun getSumInt(blockA: Array<*>): Any{
        var result = 0
        for (n in blockA) {
            if (n is Int)
                result += n
        }
        return result
    }

    private fun getSumString(blockA: Array<*>): Any{
        var result = ""
        for (n in blockA) {
            if (n is String)
                result += n
        }
        return result
    }
}
