import java.util.*
import kotlin.math.*

var arr = IntArray(1001, {0})
var check = BooleanArray(1001, {false})

fun cycle(n : Int): Int{
    var count = 0
    for(i in 1..n){
        if(check[i] == false){
            count++
            var start = i
            var end = arr[i]
            while(start != end){
                check[end] = true
                end=  arr[end]
            }
        }
    }
    return count
}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    var T = s.nextInt()
    while(T-- > 0){
        val n = s.nextInt()
        for(i in 1..n){
            arr[i] = s.nextInt()
            check[i] = false
        }
        println(cycle(n))
    }
}