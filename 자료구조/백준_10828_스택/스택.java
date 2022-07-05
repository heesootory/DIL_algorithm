import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[10001];
        int f = 0;
        while(n-- > 0){
            String str = s.next();
            if(str.equals("push")){
                int num = s.nextInt();
                arr[f] = num;
                f++;
            }
            else if(str.equals("pop")){
                if(f == 0) {
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(Integer.toString(arr[f-1]));
                    bw.newLine();
                    arr[f - 1] = 0;
                    f--;
                }
            }
            else if(str.equals("size")){
                bw.write(Integer.toString(f));
                bw.newLine();
            }
            else if(str.equals("empty")){
                if(f == 0) {
                    bw.write("1");
                    bw.newLine();
                }
                else{
                    bw.write("0");
                    bw.newLine();
                }
            }
            else if(str.equals("top")){
                if(f == 0){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(Integer.toString(arr[f-1]));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
    }
}