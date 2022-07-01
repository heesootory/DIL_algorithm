import java.util.*

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    var n = s.nextInt()
    var arr = IntArray(10, {0})
    var i = 0

    while(n >= 1){
        arr[i] = n% 10
        i+=1
        n /= 10
    }
    arr.sortDescending()
    for (j in 0 until i) print(arr[j])

}