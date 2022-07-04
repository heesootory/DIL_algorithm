import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    var arr = IntArray(100, {0})

    for(i in 0 until n) arr[i] = s.nextInt()

    var sum = 0
    for(i in n-1 downTo 1){
        if(arr[i-1] >= arr[i]){
            sum += (arr[i-1] - (arr[i] - 1))
            arr[i-1] = arr[i] - 1
        }
    }
    print(sum)

}