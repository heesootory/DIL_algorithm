import java.util.*

var a = 0
var b = 0
var q = LinkedList<Int>()
var _move = ArrayList<Int>()
var check = Array<Boolean>(100001, { false })
var seconds = Array<Int>(100001, { 0 })

fun BFS(n: Int) {
    q.add(n)
    check[n] = true
    while (q.isEmpty() == false) {
        var f = q.peek()
        q.poll()
        _move.add(f - 1)
        if (f < b) {
            _move.add(f + 1)
            _move.add(f * 2)
        }
        for (i in _move) {
            if (i >= 0 && i <= 100000) {
                if (check[i] == false) {
                    q.add(i)
                    check[i] = true
                    seconds[i] = seconds[f] + 1
                    if (i == b) return
                }
            }
        }
        _move.clear()
    }
}

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    a = s.nextInt()
    b = s.nextInt()

    BFS(a)

    print(seconds[b])
}
