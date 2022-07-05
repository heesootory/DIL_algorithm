import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    var arr = IntArray(10001, {0})
    var f = 0
    var b = 0
    while(n-- > 0){
        var str = s.next()
        if(str.equals("push")){
            var num = s.nextInt()
            arr[b] = num
            b++
        }
        else if(str.equals("pop")){
            if(f == b) bw.write("-1\n");
            else{
                bw.write(arr[f].toString() + "\n")
                arr[f] = 0
                f++
            }
        }
        else if(str.equals("size")) bw.write((b-f).toString() + "\n")
        else if(str.equals("empty")){
            if(f == b) bw.write("1\n")
            else bw.write("0\n")
        }
        else if(str.equals("front")){
            if(f == b) bw.write("-1\n")
            else bw.write(arr[f].toString() + "\n")
        }
        else if(str.equals("back")){
            if(f == b) bw.write("-1\n")
            else bw.write(arr[b-1].toString() + "\n")
        }
    }
    bw.flush()
    bw.close()
}