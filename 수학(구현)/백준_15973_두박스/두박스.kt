import java.util.*

enum class box_status{
    face,
    line,
    nul
}

fun make_status(i: Int, j:Int, k:Int, l:Int): box_status{
    var status:box_status

    if (k < i)
    {
        if (l < i) status = box_status.nul;
        else if (l == i) status = box_status.line;
        else status = box_status.face;
    }
    else if (i <= k && k < j) status = box_status.face;
    else if (k == j) status = box_status.line;
    else status = box_status.nul;

    return status;

}

fun main(args: Array<String>){
    val s = Scanner(System.`in`)
    val x1 = s.nextInt()
    val y1 = s.nextInt()
    val x2 = s.nextInt()
    val y2 = s.nextInt()

    val a1 = s.nextInt()
    val b1 = s.nextInt()
    val a2 = s.nextInt()
    val b2 = s.nextInt()

    var x_status:box_status = make_status(x1, x2, a1, a2);
    var y_status:box_status = make_status(y1, y2, b1, b2);

    if (x_status == box_status.nul || y_status == box_status.nul) print("NULL");
    else if (x_status == box_status.line && y_status == box_status.line) print("POINT");
    else if (x_status == box_status.face && y_status == box_status.face) print("FACE");
    else print("LINE");

}