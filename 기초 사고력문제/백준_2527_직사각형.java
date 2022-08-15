import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 0; t< 4; t++){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());

            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            if(c1 < a2 || b1 > d2 || b2 > d1 || a1 > c2) System.out.println('d');
            else if(((c1 == a2) && (b2 == d1)) || ((a1 == c2) && (d1 == b2)) ||
                    ((a1 == c2) && (b1 == d2)) || ((a2 ==  c1) && (b1 == d2))) System.out.println('c');
            else if((a2 == c1) || (a1 == c2) || (b1 == d2) || (d1 == b2)) System.out.println('b');
            else System.out.println('a');
        }
    }
}