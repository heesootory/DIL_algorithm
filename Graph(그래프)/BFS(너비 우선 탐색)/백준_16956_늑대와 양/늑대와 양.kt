import java.util.*
import kotlin.math.*

var medow = Array(500, {CharArray(500, {','})})
val mx = arrayOf(0, 1, 0, -1)
val my = arrayOf(1, 0, -1, 0)

fun print(arr: Array<CharArray>, r: Int, c: Int){
    for(i in 0 .. r-1){
        for(j in 0 .. c-1){
            print(arr[i][j])
        }
        println()
    }
}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    val R = s.nextInt()
    val C = s.nextInt()
    var defense = true

    for(i in 0..R-1){
        val str = s.next()
        for(j in 0..C-1){
            medow[i][j] = str[j]
        }
    }

    for(i in 0..R-1){
        for(j in 0.. C-1){
            if(medow[i][j] == 'S'){
                var b = -1
                for(a in 0..3){
                    b++
                    var new_i = i + mx[a]
                    var new_j = j + my[b]
                    if(new_i < 0 || new_j <0 || new_i > R-1|| new_j>C-1) continue
                    if (medow[new_i][new_j] == 'W') defense = false;
                    else if (medow[new_i][new_j] == 'S' || medow[new_i][new_j] == 'D') continue;
                    else medow[new_i][new_j] = 'D';
                }
            }
        }
    }

    if(defense) print("1")
    else print("0")
    println()
    print(medow, R, C)
}