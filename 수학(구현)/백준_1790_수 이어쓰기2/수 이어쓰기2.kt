import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var N: Long = s.nextLong()
    var k: Long = s.nextLong()

    var norm: Long = 1
    var norm_cnt: Long = 9
    var all_cnt: Long = 0

    while (N > norm_cnt) {
        N -= norm_cnt
        all_cnt += (norm * norm_cnt)
        norm++
        norm_cnt *= 10
    }
    all_cnt += (N * norm)

    norm = 1
    norm_cnt = 9
    var cnt: Long = 0

    while (k > cnt + (norm * norm_cnt)) {
        cnt += (norm * norm_cnt)
        norm++
        norm_cnt *= 10
    }
    var cal: Long = k - (cnt + 1)
    var quotient: Long = cal / norm
    var remainder: Long = cal % norm
    var i: Long = norm - remainder
    var num: Long = Math.pow(10.toDouble(), (norm - 1).toDouble()).toLong() + quotient

    var ans: Long = 0
    while (i-- > 0) {
        ans = num % 10
        num /= 10
    }
    if (k > all_cnt) print("-1") else print(ans)
}
