import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        long idx = 1;
        long M = 1234567891;

        for(int i = 0; i < L; i++){
            int x = str.charAt(i) - 'a' + 1;
            long ans = (x * idx) % M;       // long 범위 넘어가는 수를 방지하기 위해 나머지를 취해줌
            sum += ans;
            idx = (idx * 31) % M;           // long 범위 넘어가는 수를 방지하기 위해 나머지를 취해줌
        }
        System.out.println(sum % M);        // 계산한 수의 나머지를 구해라.
    }
}