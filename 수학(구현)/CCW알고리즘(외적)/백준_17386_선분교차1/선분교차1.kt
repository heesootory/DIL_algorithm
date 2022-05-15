import java.util.*

fun external_product(a1: Long, b1: Long, a2: Long, b2: Long, a3: Long, b3: Long): Int {
    val ans: Long = ((a1 - a2) * (b2 - b3)) - ((a2 - a3) * (b1 - b2))
    if (ans > 0) return 1 else if (ans < 0) return -1 else return 0
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val x1 = s.nextLong()
    val y1 = s.nextLong()
    val x2 = s.nextLong()
    val y2 = s.nextLong()
    val x3 = s.nextLong()
    val y3 = s.nextLong()
    val x4 = s.nextLong()
    val y4 = s.nextLong()

    val a = external_product(x1, y1, x2, y2, x3, y3)
    val b = external_product(x1, y1, x2, y2, x4, y4)
    val c = external_product(x3, y3, x4, y4, x1, y1)
    val d = external_product(x3, y3, x4, y4, x2, y2)

    if (a * b <= 0 && c * d <= 0) print("1") else print("0")
}
