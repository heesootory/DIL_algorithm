import java.util.*

fun GCD(a: Int, b: Int): Int {
    var p = Math.max(a, b)
    var q = Math.min(a, b)
    var left = p % q
    while (left != 0) {
        p = q
        q = left
        left = p % q
    }
    return q
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val g = s.nextInt()
    val l = s.nextInt()

    if (g == l) print("${g} ${g}")
    else {
        var p = l / g
        var sum = p + 2
        var a = 0
        var b = 0
        for (i in 1..p) {
            if (p % i == 0) {
                var j = p / i
                if (GCD(i, j) == 1) {
                    if (i + j < sum) {
                        sum = i + j
                        a = i
                        b = j
                    } else break
                }
            }
        }
        if (a < b) print("${a*g} ${b*g}") else print("${b*g} ${a*g}")
    }
}
