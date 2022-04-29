import java.util.*

var n = 0
var m = 0
var max_cnt = 0

class shark {
    var x = 0
    var y = 0
    constructor(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}

var sea = Array(51, { Array(51, { 0 }) })
val mx = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
val my = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
var q = LinkedList<shark>()

fun BFS() {
    while (q.isEmpty() == false) {
        var sh = q.peek()
        q.poll()
        for (i in 0..7) {
            var new_x = sh.x + mx[i]
            var new_y = sh.y + my[i]
            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                if (sea[new_x][new_y] == 0) {
                    sea[new_x][new_y] = sea[sh.x][sh.y] + 1
                    var sh_possible = shark(new_x, new_y)
                    q.add(sh_possible)
                    if (sea[new_x][new_y] > max_cnt) max_cnt = sea[new_x][new_y]
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    n = s.nextInt()
    m = s.nextInt()
    for (i in 0..n - 1) {
        for (j in 0..m - 1) {
            var k = s.nextInt()
            sea[i][j] = k
            var sh_position = shark(i, j)
            if (k == 1) q.add(sh_position)
        }
    }
    BFS()

    print(max_cnt - 1)
}
