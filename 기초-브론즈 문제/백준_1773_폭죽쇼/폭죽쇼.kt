import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    val c = s.nextInt()
    var fire = BooleanArray(2000001, {false})
    var time = IntArray(n, {0})
    for(i in 0..n-1)
        time[i] = s.nextInt()

    var cnt = 0
    for(i in 0..n-1){
        for(j in time[i]..c step time[i]){
            if(fire[j]) continue
            fire[j] = true
            cnt++
        }
    }
    print("${cnt}")

}


