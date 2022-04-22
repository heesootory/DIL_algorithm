import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = LongArray(1001)
    arr[0] = 0; arr[1] = 1; arr[2] = 3;
    val s = Scanner(System.`in`)
    val n = s.nextInt()

    for(i in 3..n){
        arr[i] = arr[i-1]*2
        if(i % 2 ==0 ) arr[i]++
        else arr[i]--
        arr[i] = arr[i] %10007
    }
    println(arr[n])

}