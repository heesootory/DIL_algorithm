import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    val m = s.nextInt()
    var arr = IntArray(100, { 0 })

    for(i in 0..n-1) arr[i] = s.nextInt()

    var max = 0;
    for(i in 0..n-3){
        for(j in i+1..n-2){
            for(k in j+1.. n-1){
                var sum = arr[i] + arr[j] + arr[k]
                if(sum <= m){
                    if(max < sum) max = sum
                }
            }
        }
    }
    print(max)

}