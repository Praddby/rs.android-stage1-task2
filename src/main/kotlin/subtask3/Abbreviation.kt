package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val mutableList = a.toUpperCase().chunked(1) as MutableList
        val immutableList = b.chunked(1)
        if ( !mutableList.containsAll(immutableList) ) return "NO"

        mutableList.retainAll(immutableList)
        val arrayList = mutableListOf<String>()
        var i = 0
        var j = 0
        do {
            if (immutableList[j] == mutableList[i]) {
                arrayList.add(immutableList[j])
                i++
                j++
            } else
                i++
        } while(immutableList.size > j && mutableList.size > i)

        return if (immutableList == arrayList)
            "YES"
        else
            "NO"
    }
}
