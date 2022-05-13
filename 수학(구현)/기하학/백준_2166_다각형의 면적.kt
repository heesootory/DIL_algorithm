import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val N = s.nextInt()
    var x = 0
    var y = 0
    var first_x = 0
    var first_y = 0
    var past_x = 0
    var past_y = 0
    var sum1: Long = 0L
    var sum2: Long = 0L

    for (i in 1..N) {
        x = s.nextInt()
        y = s.nextInt()
        if (i == 1) {
            first_x = x
            first_y = y
        }
        sum1 += (past_x.toLong() * y)
        sum2 += (past_y.toLong() * x)
        past_x = x
        past_y = y
    }
    sum1 += (past_x.toLong() * first_y)
    sum2 += (past_y.toLong() * first_x)

    val max_sum = Math.max(sum1, sum2)
    val min_sum = Math.min(sum1, sum2)
    var ans: Double = (max_sum - min_sum) / 2.0
    ans = Math.round(ans * 10) / 10.0
    print("%.1f".format(ans))
}
