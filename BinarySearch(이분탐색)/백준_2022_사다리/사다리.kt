import java.util.*

fun mid_height(x: Double, y: Double, m: Double): Double {
    var h1 = Math.sqrt(Math.pow(x, 2.0) - Math.pow(m, 2.0))
    var h2 = Math.sqrt(Math.pow(y, 2.0) - Math.pow(m, 2.0))
    return (h1 * h2) / (h1 + h2)
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var x = s.nextDouble()
    var y = s.nextDouble()
    var c = s.nextDouble()

    var max_len: Double = Math.min(x, y)
    var min_len: Double = 0.0
    var mid: Double = 0.0

    while (max_len - min_len > 0.000001) {
        mid = (max_len + min_len) / 2.0
        var result: Double = mid_height(x, y, mid)
        if (c <= result) min_len = mid else max_len = mid
    }
    print("%.3f".format(mid))
}
