import java.util.*

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    var n = s.nextInt()
    var arr = IntArray(10, {0})
    while(n >= 1){
        var i = n % 10
        if(i == 9) i = 6
        arr[i]+=1
        n /= 10
    }
    if(arr[6] % 2 == 0) arr[6] /= 2
    else arr[6] = arr[6] / 2 + 1
    var max = 0
    for(i in 0 until arr.size)
        if(arr[i] > max) max = arr[i]
    println(max)
}