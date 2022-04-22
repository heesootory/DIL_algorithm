import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = LongArray(1001)
    arr[0] = 0; arr[1] = 1; arr[2] = 2;
    val s = Scanner(System.`in`)
    val n = s.nextInt()

    for(i in 3..n){
        arr[i] = (arr[i-1] + arr[i-2])%10007
    }
    println(arr[n])

}