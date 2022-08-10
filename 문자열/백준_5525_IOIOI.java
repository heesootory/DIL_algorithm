package 문자열;

public enum 백준_5525_IOIOI {
import java.io.*;
import java.util.*;

/**
 * 문자열 정렬
 *
 * 반복되는 탐색을 줄이는게 관건임.
 * 문자열은 subString을 활용하자....
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int size = n * 2 + 1;
        int i = 0;
        int len = 1;
        int cnt = 0;

        while(i < m - 2){
            if(str.substring(i, i+3).equals("IOI")){
                i += 2;
                len += 2;
                if(len == size){
                    cnt++;
                    len -= 2;
                }
            }
            else{
                i++;
                len = 1;
            }
        }
        System.out.println(cnt);
    }
}
}
