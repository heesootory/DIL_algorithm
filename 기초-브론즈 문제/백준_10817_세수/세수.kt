import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var arr = IntArray(3, {0})
    for(i in 0..2)
        arr[i] = s.nextInt()
    arr.sort()
    print("${arr[1]}")

}