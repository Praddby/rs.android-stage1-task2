package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        return if (inputString.toLowerCase().chunked(1).containsAll(alphabet))
            getPangram(inputString)
        else
            getNotPangram(inputString)
    }

    private val alphabet = listOf("a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j", "k", "l", "m", "n", "o", "p", "q",
        "r", "s", "t", "u", "v", "w", "x", "y", "z")

    private fun getPangram(str: String): String {
        val list = str.split("\n"," ").filter{ c -> c.isNotEmpty() }.map { s ->
            "${s.count{ c -> c == 'e' || c == 'a' || c== 'i' || c== 'o' || c == 'u' || c == 'y'}}$s "
        }
        val strPlusNumber = buildString {
            for (s in list.sortedBy { it[0] })
                append(s)
        }
        val newStr = strPlusNumber.map { c ->
            if (listOf('a', 'e', 'i', 'o', 'u', 'y').contains(c))
                c.toUpperCase()
            else
                c
        }
        return buildString {
            for (s in newStr)
                append(s)
        }.trim()
    }

    private fun getNotPangram(str: String): String {
        val list = str.split("\n", " ").filter{ c -> c.isNotEmpty() }.map { s ->
            "${s.toLowerCase().count{ c ->
                c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' ||
                c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'q' || 
                c == 'r' || c == 's' || c == 't' || c == 'v' || c == 'w' || c == 'x' || c == 'z'
            }}$s "
        }
        val strPlusNumber = buildString {
            for (s in list.sortedBy { it[0] })
                append(s)
        }
        val newStr = strPlusNumber.map { c ->
            if (!listOf('a', 'e', 'i', 'o', 'u', 'y').contains(c))
                c.toUpperCase()
            else
                c
        }
        return buildString {
            for (s in newStr)
                append(s)
        }.trim()
    }
}
