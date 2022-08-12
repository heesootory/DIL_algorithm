import java.util.*

fun main(args: Array<String>) {
    val month = arrayOf<Int>(31,28,31,30,31,30,31,31,30,31,30,31)
    val week = arrayOf<String>("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

    val s = Scanner(System.`in`)
    val m = s.nextInt()
    val d = s.nextInt()

    var sum = 0
    for (i in 0..m-2) sum += month[i]
    sum += (d-1)
    print(week[sum % 7])

}