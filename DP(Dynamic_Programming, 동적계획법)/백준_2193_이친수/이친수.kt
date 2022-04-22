import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = LongArray(91)
    arr[1] = 1

    val s = Scanner(System.`in`)
    val input = s.nextInt()

    for(i in 2..input){
        arr[i] = arr[i-1] + arr[i-2]
    }

    print(arr[input])

}