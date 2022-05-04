import java.util.*

fun main(args: Array<String>){
    var s = Scanner(System.`in`)
    var N = s.nextInt()

    var sum = 0
    var m = 9
    val ten_mul = 10
    var i = 1
    var norm = m

    while(N > norm){
        N -= norm
        sum += (norm * i)
        i += 1
        norm = m * Math.pow(ten_mul.toDouble(), (i-1).toDouble()).toInt()
        // 코틀린은 엄격히 pow내부의 변수도 모두 double형으로 필요.
    }
    sum += (N*i)
    print(sum)
}