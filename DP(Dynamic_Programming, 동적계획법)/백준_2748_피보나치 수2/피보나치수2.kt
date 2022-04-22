import java.util.*

var d = LongArray(100, {0})

fun dp(n: Int):Long {
    if(n == 0) return 0
    if(n == 1) return 1

    if(d[n] > 0) return d[n]

    d[n] = dp(n-1) + dp(n-2)

    return d[n]
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val input = s.nextInt()
    print("${dp(input)}")
}