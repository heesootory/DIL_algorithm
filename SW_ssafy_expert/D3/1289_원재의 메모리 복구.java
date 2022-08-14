import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            String str = br.readLine();

            int cnt = 0;
            if(str.charAt(0) == '1') cnt++;
            for(int i = 1; i< str.length(); i++){
                if(str.charAt(i) != str.charAt(i-1)) cnt++;
            }


            System.out.println("#" + t + " " + cnt);
        }

    }
}
