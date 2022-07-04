import java.util.*
import kotlin.math.min

var n = 0

fun check (arr : IntArray, evg : Int) : Boolean{
    for(i in 0 until n){
        if(arr[i] < evg) return false
    }
    return true
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    n = s.nextInt()
    var arr = IntArray(n, {0})
    var sum = 0
    var max = 0
    for(i in 0 until n){
        arr[i] = s.nextInt()
        if(arr[i] > max) max = arr[i]
        sum += arr[i]
    }

    arr.sort()
    val total = s.nextInt()
    var evg = total /n

    if(sum <= total) print(max)
    else if(check(arr, evg)) print(evg)
    else{
        var start = 0
        var end = 0
        var mid = 0
        for(i in 0 until n-1){
            var norm1 = arr[i]
            var norm2 = arr[i+1]
            var sum1 = 0
            var sum2 = 0
            for(j in 0 until n){
                if(arr[j] > norm1) sum1 += norm1
                else sum1 += arr[j]
                if(arr[j] > norm2) sum2 += norm2
                else sum2 += arr[j]
            }
            if(sum1 <= total && total <= sum2){
                start = norm1
                end = norm2
            }
        }
        while(end - start > 1){
            var max_sum = 0
            mid = (start+ end) /2

            for(i in 0 until n){
                if(arr[i] > mid) max_sum += mid
                else max_sum += arr[i]
            }
            if(max_sum > total) end = mid
            else start = mid
        }
        print(start)
    }
}