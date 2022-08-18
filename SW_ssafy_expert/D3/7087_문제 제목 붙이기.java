import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){

            int n = Integer.parseInt(br.readLine());
            char[] arr = new char[n];

            for(int i = 0; i < n; i++){
                String str = br.readLine();
                arr[i] = str.charAt(0);
            }

            Arrays.sort(arr);
            int cnt = 0;

            if(arr[0] == 'A'){
                cnt++;
                for(int i = 1; i < n; i++){
                    if(arr[i-1] == arr[i]) continue;
                    else if((int)arr[i] - (int)arr[i-1] == 1) cnt++;
                    else break;
                }
            }

            System.out.printf("#%d %d\n", t, cnt);
        }

    }
}
