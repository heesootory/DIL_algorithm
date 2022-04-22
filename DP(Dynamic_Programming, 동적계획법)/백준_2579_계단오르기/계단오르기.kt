import java.util.*
import kotlin.math.*

fun main(args: Array<String>){
    val stairs = IntArray(302)
    val sum = IntArray(302)
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    for(i in 1..n){
        stairs[i] = s.nextInt()
    }

    sum[1] = stairs[1]
    sum[2] = stairs[1] + stairs[2]
    sum[3] = Math.max(stairs[1], stairs[2])+ stairs[3]
    for(i in 4..n){
        sum[i] = Math.max(sum[i-3]+stairs[i-1], sum[i-2])+stairs[i]
    }

    print(sum[n])
}