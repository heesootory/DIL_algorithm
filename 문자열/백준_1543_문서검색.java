import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        String norm = br.readLine();

        int len = norm.length();
        int cnt = 0;
        int i = 0;
        while(i < str.length() - len + 1){
            if(str.substring(i, i+len).contains(norm)){
                cnt++; i += len;
            }
            else i++;
        }

        System.out.println(cnt);
    }
}