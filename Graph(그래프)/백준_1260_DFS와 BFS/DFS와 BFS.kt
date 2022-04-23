import java.util.*
import kotlin.math.*

var edge = Array<ArrayList<Int>>(1001) {ArrayList<Int>()}
var check = BooleanArray(1001, {false})

fun DFS(n: Int){
    if(check[n] == true) return

    print("${n} ")
    check[n] = true
    for(i in edge[n]) DFS(i)
}

fun BFS(n: Int){
    var q = LinkedList<Int>()
    q.add(n)
    check[n] = true

    while(q.isEmpty() == false){
        var f = q.peek()
        q.poll()
        print("${f} ")
        for(i in edge[f]){
            if(check[i] == false){
                q.add(i)
                check[i] = true
            }
        }
    }
}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    val N = s.nextInt()
    var M = s.nextInt()
    val v = s.nextInt()

    while(M-- >0){
        val a = s.nextInt()
        val b = s.nextInt()
        edge[a].add(b)
        edge[b].add(a)
    }

    for(i in 0..N) edge[i].sort()
    DFS(v)
    for(i in 0..N) check[i] = false
    println()
    BFS(v)

}