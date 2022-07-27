import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i =0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long max = 0;
        for(int i = 0, j = n; i < n; i++, j--){
            max = Math.max(max, arr[i]*j);
        }
        System.out.println(max);
    }
}