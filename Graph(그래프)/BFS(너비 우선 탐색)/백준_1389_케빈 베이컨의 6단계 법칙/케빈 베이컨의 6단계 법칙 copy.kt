import java.util.*

var n = 0
var m = 0
var user = Array<ArrayList<Int>>(101) { ArrayList<Int>() }
var check = Array<Boolean>(101, { false })
var friends = Array<Int>(101, { 0 })
var q = LinkedList<Int>()
var min_count = 101

fun BFS(n: Int) {
    q.add(n)
    check[n] = true
    while (q.isEmpty() == false) {
        var f = q.peek()
        q.poll()
        for (i in user[f]) {
            if (check[i] == false) {
                check[i] = true
                friends[i] = friends[f] + 1
                q.add(i)
            }
        }
    }
}

fun friends_init_sum(): Int {
    var sum = 0
    for (i in 0..n) {
        sum += friends[i]
        friends[i] = 0
    }
    return sum
}

fun check_init() {
    for (i in 0..n) check[i] = false
}

fun main(args: Array<String>) {
    var s = Scanner(System.`in`)
    n = s.nextInt()
    m = s.nextInt()
    while (m-- > 0) {
        var a = s.nextInt()
        var b = s.nextInt()
        user[a].add(b)
        user[b].add(a)
    }
    var min_who = 0
    for (i in 1..n) {
        BFS(i)
        check_init()
        var fri_sum = friends_init_sum()
        if (min_count > fri_sum) {
            min_count = fri_sum
            min_who = i
        }
    }
    print(min_who)
}
