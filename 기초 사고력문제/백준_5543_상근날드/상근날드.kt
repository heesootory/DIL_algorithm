import java.util.*

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var min1 = 2000
    for(i in 0..2){
        var burger = s.nextInt();
        if(burger < min1) min1 = burger
    }
    var min2 = 2000
    for(i in 0..1){
        var drink = s.nextInt()
        if(drink < min2) min2 = drink
    }

    print("${min1 + min2 - 50}")
}