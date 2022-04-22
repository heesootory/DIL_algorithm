import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = IntArray(11)
    arr[1] = 1; arr[2] = 2; arr[3] = 4;
    val s = Scanner(System.`in`)
    val T = s.nextInt()
    for(i in 1..T){
        val n = s.nextInt()
        if(arr[n] > 0) println("${arr[n]}")
        else{
            for(j in 4..n){
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            println(arr[n])
        }
    }
}