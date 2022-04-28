import java.util.*
import kotlin.math.*

var check = BooleanArray(1001, {false})
var arr_list = Array<ArrayList<Int>>(1001) {ArrayList<Int>()}

fun DFS(n: Int){
    for(i in arr_list[n]){
        if(check[i] == false){
            check[i] = true
            DFS(i)
        }
    }
}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    var N = s.nextInt()
    var M = s.nextInt()

    while(M-- >0){
        var a = s.nextInt()
        var b = s.nextInt()
        arr_list[a].add(b)
        arr_list[b].add(a)
    }

    var count = 0;
    for(i in 1..N){
        if(check[i] == false){
            check[i] = true
            count++
            DFS(i)
        }
    }
    print(count)
}