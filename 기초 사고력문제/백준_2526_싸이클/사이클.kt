import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    val p = s.nextInt()
    var m = n;
    var arr =  IntArray(1001, {0})
    var cnt = 0

    while(true){
        var i = (m*n)%p;
        if(arr[i] > 2) break
        arr[i]++
        m = i
        if(arr[i] == 2) cnt++
    }
    print("${cnt}")

}