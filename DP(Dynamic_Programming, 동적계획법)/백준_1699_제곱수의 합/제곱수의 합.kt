import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val arr = IntArray(100000)

    val s = Scanner(System.`in`)
    val input = s.nextInt()

    for(i in 0..input){
        arr[i] = i
        var j = 0
        while(j*j<=i){
            arr[i] = min(arr[i], arr[i-j*j] + 1)
            j++
        }
    }
    print(arr[input])

}