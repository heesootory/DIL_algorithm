import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0;  t < T; t++){

            String str = br.readLine();
            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                cnt = (str.charAt(i) == 'X') ? 0 : cnt + 1;
                sum += cnt;
            }
            System.out.println(sum);

        }
    }
}
