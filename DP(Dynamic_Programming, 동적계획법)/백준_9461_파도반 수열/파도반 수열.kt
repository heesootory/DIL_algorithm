import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = LongArray(101)
    arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2;
    val s = Scanner(System.`in`)
    val T = s.nextInt()
    for(i in 1..T){
        val n = s.nextInt()
        if(n < 6) println(arr[n])
        else{
            for(j in 6..n){
                arr[j] = arr[j-1] + arr[j-5];
            }
            println(arr[n])
        }

    }
}