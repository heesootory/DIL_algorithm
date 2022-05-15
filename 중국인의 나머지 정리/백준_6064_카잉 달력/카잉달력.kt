import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var _case = s.nextInt()
    while (_case-- > 0) {
        var M = s.nextInt()
        var N = s.nextInt()
        var x = s.nextInt()
        var y = s.nextInt()

        var i = x
        var iss = false

        var a = M
        var b = N
        var left = 0
        while (true) {
            left = a % b
            if (left == 0) break
            a = b
            b = left
        }

        var gcd = b
        var lcd = (M / gcd * N / gcd * gcd)

        if (N == y) y = 0
        while (i <= lcd) {
            if (i % N == y) {
                iss = true
                break
            }
            i += M
        }
        if (iss) println(i) else println(-1)
    }
}
