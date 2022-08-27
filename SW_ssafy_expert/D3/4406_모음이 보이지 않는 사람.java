import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            String str = br.readLine();

            System.out.printf("#%d ", t);
            for(int i = 0; i < str.length(); i++){
                char x = str.charAt(i);
                if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') continue;
                System.out.printf("%c", x);
            }
            System.out.println();

        }
    }
}