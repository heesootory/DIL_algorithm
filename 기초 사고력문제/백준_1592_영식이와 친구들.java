import java.io.*;
import java.util.*;


public class Main {
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        int i = 1;
        while(true){
            arr[i]++;
            if(arr[i] == m) break;

            i = (arr[i] % 2 == 0) ? (i+l) % n : i-l;
            if(i <= 0) i += n;
            cnt++;
        }

        System.out.println(cnt);

    }
}