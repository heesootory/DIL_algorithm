import java.util.*
import kotlin.math.*

var arr = Array(52, {BooleanArray(52)})

fun DFS(i : Int, j : Int) {
    if (arr[i][j] == false) return;

    arr[i][j] = false;
    DFS(i + 1, j);
    DFS(i + 1, j - 1);
    DFS(i + 1, j + 1);
    DFS(i, j - 1);
    DFS(i, j + 1);
    DFS(i - 1, j);
    DFS(i - 1, j - 1);
    DFS(i - 1, j + 1);
}


fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    var w = 0
    var h = 0
    var k = 0
    while(true){
        w = s.nextInt()
        h = s.nextInt()
        if(w == 0 && h == 0) break;
        var count = 0
        for( i in 1..h){
            for(j in 1..w){
                k = s.nextInt()
                if(k == 1) arr[i][j] = true;
            }
        }
        for(i in 1.. h){
            for( j in 1.. w){
                if(arr[i][j]){
                    count++;
                    DFS(i, j)
                }
            }
        }
        println(count)
    }
}