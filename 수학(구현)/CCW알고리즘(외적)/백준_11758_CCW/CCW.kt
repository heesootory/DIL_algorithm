import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val x1 = s.nextInt()
    val y1 = s.nextInt()
    val x2 = s.nextInt()
    val y2 = s.nextInt()
    val x3 = s.nextInt()
    val y3 = s.nextInt()

    val external =(((x2 - x1) * (y3 - y2)) - ((x3 - x2) * (y2 - y1)))
    if (external > 0) print("1");
    else if (external < 0) print("-1");
    else print("0");

}


