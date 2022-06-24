import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val a = s.nextInt()
    val b = s.nextInt()
    val c = s.nextInt()
    var mul = a*b*c
    var arr = IntArray(10, {0})

    while(mul >= 1){
        var i = mul %10
        arr[i]++
        mul /= 10
    }

    for(i in 0..9)
        println("${arr[i]}")

}