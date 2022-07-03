import java.util.*

var arr = Array(200, {CharArray(400, {' '})})

fun set(n : Int, r: Int,  idx : Int){
    var row = 2*n-1
    var col = 4*n-3

    for(i in 0..col - idx) arr[r][i] = ' '

    if(r == 0 || r == row - 1){
        for(i in 0 until n) arr[r][i] = '*'
        for(i in col - n until col) arr[r][i] = '*'
    }
    else{
        arr[r][idx] = '*'
        arr[r][idx + n - 1] = '*'
        arr[r][col - idx - 1] = '*'
        arr[r][col - idx - n] = '*'
    }
    for(i in 0..col-idx) print(arr[r][i])
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    var idx = 0
    for(i in 0 until 2*n-1){
        set(n, i, idx)
        if(i < n-1) idx++
        else idx--
        println()
    }
}