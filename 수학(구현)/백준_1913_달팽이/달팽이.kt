import java.util.*

fun main(args: Array<String>) {
    val sb = StringBuilder()
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    val m = s.nextInt()

    var arr = Array(1000, {IntArray(1000, {0})})
    var k = 1
    var i = n/2
    var j = n/2
    var num = 1

    arr[i][j] = num
    while(k <= n){
        if(k == n){
            for(r in 0 until k-1){
                i--
                num++
                arr[i][j] = num
            }
        } else if (k % 2 != 0) {
            for (r in 0 until k) {
                i--
                num++
                arr[i][j] = num
            }
            for (r in 0 until k) {
                j++
                num++
                arr[i][j] = num
            }
        } else {
            for (r in 0 until k) {
                i++
                num++
                arr[i][j] = num
            }
            for (r in 0 until k) {
                j--
                num++
                arr[i][j] = num
            }
        }
        k++
    }

    var ans_i = 0
    var ans_j = 0
    for(a in 0 until n){
        for( b in 0 until n){
            sb.append("${arr[a][b]} ")
            if(arr[a][b] == m){
                ans_i = a
                ans_j = b
            }
        }
        sb.append("\n")
    }
    sb.append("${ans_i + 1} ${ans_j + 1}")
    println(sb)
}