import java.util.*

val d = IntArray(50, {0})

fun dp(n: Int):Int {
    if(n <= 1) return n

    if(d[n] > 0) return d[n]

    d[n] = dp(n-1) + dp(n-2)

    return d[n]
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val input = s.nextInt()
    print("${dp(input)}")
}