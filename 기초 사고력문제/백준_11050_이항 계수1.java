import java.io.*;
import java.util.*;

public class test {
    static int fact(int n, int cnt){
        if(cnt == 0) return 1;
        else return n * fact(n-1, cnt-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(fact(n, k) / fact(k , k));

    }
}