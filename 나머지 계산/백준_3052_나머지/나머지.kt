import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var arr = IntArray(42, {0})
    var num = 10
    var a = 0

    while(num-- > 0){
        a = s.nextInt()
        arr[a%42] += 1
    }
    var cnt = 0
    for(i in 0..41){
        if(arr[i] > 0) cnt+=1
    }
    print(cnt)

}