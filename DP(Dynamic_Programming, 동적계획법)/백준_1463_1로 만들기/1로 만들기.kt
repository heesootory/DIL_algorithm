import java.util.*

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    val input = s.nextInt()
    var min = 1000000

    fun dp(x: Int, count : Int){
        if(x <= 1){
            if(count< min) min = count
            return
        }

        if(x % 3 == 0) {
            if(count > min) return
            dp(x/3, count+1)
        }
        if(x % 2 == 0) {
            if(count > min) return
            dp(x/2, count+1)
        }
        if(count > min) return
        dp(x-1, count+1)

        return
    }

    dp(input, 0)

    print(min)


}