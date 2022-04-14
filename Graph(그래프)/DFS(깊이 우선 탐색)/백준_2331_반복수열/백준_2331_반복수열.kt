import java.util.*

var count_arr = Array<Int>(300000) {0}

fun DFS(a: Int, p: Int){        //주의! 코를린 함수의 매개변수는 무조건 val!
    var x = a                   //a값 변경을 위해 var변수 생성
    var new_a = 0
    while(x > 0){
        var left = x % 10
        var leftsquare = 1
        for(i in 1..p) leftsquare *= left       //pow함수 쓰지 않고 for문으로 직접 제곱수 구함
        new_a += leftsquare
        x /= 10
    }

    count_arr[new_a]++                          //새로운 수. 배열에 체크
    if(count_arr[new_a] > 2) return
    DFS(new_a, p)
}

fun main(args: Array<String>) {         //var - 변경가능, val - 변경불가 변수
    val s = Scanner(System.`in`)
    val A = s.nextInt(); val P = s.nextInt()

    count_arr[A]++
    DFS(A, P);
    var count = 0
    for(i in count_arr)
        if(i == 1) count++

    print("${count}")


}