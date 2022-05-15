import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()

    for (i in 1..n) {
        var start = s.nextInt()
        var end = s.nextInt()
        var term = end - start

        if (term == 1) println("1")
        else if (term == 2) println("2")
        else {
            var num1: Long = 2
            var num_plus: Long = 1
            var num2: Long = 3
            var cnt: Long = 2

            while (true) {
                cnt++
                num1 += num_plus
                num_plus++
                num2 += num_plus
                if (num1 <= term && term < num2) break

                cnt++
                num1 += num_plus
                num2 += num_plus
                if (num1 <= term && term < num2) break
            }
            println(cnt)
        }
    }
}
