import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val apt = Array(15, {IntArray(15)})

    for((i, iv) in apt.withIndex()){
        for((j, jv) in iv.withIndex()){
            if(i == 0) apt[i][j] = j
            else{
                if(j == 1) apt[i][j] = 1
                else if(j > 1) apt[i][j] = apt[i-1][j] + apt[i][j-1]
            }
        }
    }

    var t = s.nextInt()
    var k = 0
    var n = 0
    while(t-- > 0){
        k = s.nextInt()
        n = s.nextInt()
        println("${apt[k][n]}")
    }

}