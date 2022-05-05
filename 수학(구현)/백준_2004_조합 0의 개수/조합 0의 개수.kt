import java.util.*

fun count_zero(n: Int, k: Int): Int {
    var cnt = 0
    var i: Long = k.toLong()
    while (i <= n) {
        cnt += (n / i).toInt()
        i *= k
    }
    return cnt
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    val m = s.nextInt()

    var f = count_zero(n, 5) - count_zero(m, 5) - count_zero(n - m, 5)
    var t = count_zero(n, 2) - count_zero(m, 2) - count_zero(n - m, 2)

    print(Math.min(f, t))
}
