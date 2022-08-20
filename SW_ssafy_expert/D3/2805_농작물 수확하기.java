import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int idx = n/2;
            int k = 0;
            for(int i = 0; i< n; i++){
                String str = br.readLine();
                for(int j = idx ; j <= idx+k; j++){
                    sum += (str.charAt(j) - '0');
                }
                if(i < n/2){
                    idx--; k+=2;
                }
                else{
                    idx++; k-=2;
                }
            }
            System.out.printf("#%d %d\n", t, sum);

        }
    }
}
