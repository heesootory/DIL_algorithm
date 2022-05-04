import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val sick_finger: Long = s.nextLong()
    val can_count: Long = s.nextLong()

    var num_count: Long = 0

    if (can_count == 0L) {
        for (i in 1 until sick_finger) num_count++
    } else {
        if (sick_finger == 1L || sick_finger == 5L) {
            num_count += (4 * 2 * can_count)
            for (i in 1 until sick_finger) num_count++
        } else {
            num_count += (4 * can_count)
            if (can_count % 2 == 0L) {
                for (i in 1 until sick_finger) num_count++
            } else {
                for (i in 5 downTo sick_finger + 1 step 1) num_count++
            }
        }
    }
    print(num_count)
}
