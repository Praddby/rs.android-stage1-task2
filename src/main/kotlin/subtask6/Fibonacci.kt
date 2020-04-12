package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        if (n == 0)  return intArrayOf(0, 1, 1)
        if (n == 1)  return intArrayOf(1, 1, 1)
        for (m in 0..n){
            if (m == 0 || m == 1)  continue
            when {
                fibonacci(m) * fibonacci(m+1) == n ->
                    return intArrayOf(fibonacci(m), fibonacci(m+1), 1)
                (fibonacci(m) * fibonacci(m+1)) > n && (fibonacci(m) * fibonacci(m-1)) < n ->
                    return intArrayOf(fibonacci(m), fibonacci(m+1), 0)
            }
        }
        return intArrayOf()
    }

    private fun fibonacci (n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return fibonacci(n-1) + fibonacci(n-2)
    }
}
