import java.util.*

fun is_prime(n : Int): Boolean{
    for(i in 2..n){
        if(i*i >n) break;
        if(n %i ==0) return false
    }
    return true
}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    var a = 0
    while(true){
        var n = s.nextInt()
        if(n == 0) break

        for(i in 3..n-1 step 2){
            if(is_prime(i) && is_prime(n-i)){
                a = i; break
            }
        }
        if(a == 0) println("Goldbach's conjecture is wrong.");
        else println("${n} = ${a} + ${n-a}")
    }

}