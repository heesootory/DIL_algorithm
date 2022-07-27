import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += (arr1[i] * arr2[j]);
        }
        System.out.println(sum);
    }
}