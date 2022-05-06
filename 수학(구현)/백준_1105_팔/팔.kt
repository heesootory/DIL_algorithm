import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val L = s.nextInt()
    val R = s.nextInt()
    var min_cnt = 10

    for (i in L..R) {
        var n = i
        var cnt = 0
        while (n > 0) {
            if (n % 10 == 8) cnt++
            n /= 10
        }
        if (cnt < min_cnt) min_cnt = cnt
        if (min_cnt == 0) break
    }
    print(min_cnt)
}
