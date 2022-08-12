import java.util.*

fun room(stu: Int, k: Int) : Int{
    var sum_room = 0
    sum_room += (stu /k)
    if(stu % k != 0) sum_room += 1
    return sum_room
}

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    val k = s.nextInt()

    var arr = Array(2, {IntArray(6, {0})})

    while(n-- > 0){
        var a = s.nextInt()
        var b = s.nextInt()
        arr[a][b-1]++
    }

    var smw = arr[0][0] + arr[1][0] + arr[0][1] + arr[1][1];
    var mm = arr[1][2] + arr[1][3];
    var mw = arr[0][2] + arr[0][3];
    var hm = arr[1][4] + arr[1][5];
    var hw = arr[0][4] + arr[0][5];
    var sum = 0;
    sum += room(smw, k);
    sum += room(mm, k);
    sum += room(mw, k);
    sum += room(hm, k);
    sum += room(hw, k);
    print(sum)
}