import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    var arr = IntArray(10001, {0})
    var f = 0
    while(n-- > 0){
        var str = s.next()
        if(str.equals("push")){
            var num = s.nextInt()
            arr[f] = num
            f++
        }
        else if(str.equals("pop")){
            if(f == 0) bw.write("-1\n");
            else{
                bw.write(arr[f-1].toString() + "\n")
                arr[f-1] = 0
                f--
            }
        }
        else if(str.equals("size")) bw.write(f.toString() + "\n")
        else if(str.equals("empty")){
            if(f == 0) bw.write("1\n")
            else bw.write("0\n")
        }
        else if(str.equals("top")){
            if(f == 0) bw.write("-1\n")
            else bw.write(arr[f-1].toString() + "\n")
        }
    }
    bw.flush()
    bw.close()
}