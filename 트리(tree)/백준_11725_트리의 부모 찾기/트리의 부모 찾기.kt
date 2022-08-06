import java.util.*

var check = Array<Boolean>(100001) { false }
var parent_node = Array<Int>(100001) { 0 }
var edge = Array<ArrayList<Int>>(100001) { ArrayList<Int>() }
var q = LinkedList<Int>()

fun BFS(n: Int) {
    q.add(n)
    check[n] = true

    while (q.isEmpty() == false) {
        var f = q.peek()
        q.poll()
        for (i in edge[f]) {
            if (check[i] == false) {
                check[i] = true
                parent_node[i] = f
                q.add(i)
            }
        }
    }
}

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    var N = s.nextInt()
    var M = N - 1

    while (M-- > 0) {
        var a = 0
        var b = 0
        a = s.nextInt()
        b = s.nextInt()
        edge[a].add(b)
        edge[b].add(a)
    }

    BFS(1)

    for (i in 2..N) println(parent_node[i])
}
