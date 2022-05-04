import java.util.*

fun is_prime(n: Int): Boolean {
    for (i in 2..n) {
        if (i * i > n) break
        if (n % i == 0) return false
    }
    return true
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = 0
    while (true) {
        n = s.nextInt()
        if (n == 0) break
        var count = 0

        for (i in n + 1..n * 2) {
            if (is_prime(i)) count++
        }
        println(count)
    }
}
