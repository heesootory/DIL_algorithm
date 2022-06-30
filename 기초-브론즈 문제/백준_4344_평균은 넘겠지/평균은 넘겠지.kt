import java.util.*

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    var m = s.nextInt()

    while(m-- > 0){
        var n = s.nextInt()
        var arr = IntArray(n, {0})
        var ever = 0
        for (i in 0..n-1){
            arr[i] = s.nextInt()
            ever += arr[i]
        }
        ever /= n
        var cnt = 0
        for(i in 0..n-1)
            if(arr[i] > ever) cnt+=1

        var ans = (cnt*100/n.toFloat()) //형변환
        println("%.3f%%".format(ans))
    }

}