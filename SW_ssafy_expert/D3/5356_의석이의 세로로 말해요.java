import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 5356_의석이의 세로로 말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t++){

            char[][] arr = new char[5][16];
            for(int i = 0; i < arr.length; i++) Arrays.fill(arr[i], '.');

            int max_len = 0;
            for(int i = 0; i < 5; i++){
                String str = br.readLine();
                if(max_len < str.length()) max_len = str.length();
                for(int j = 0; j < str.length(); j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int j = 0; j < max_len; j++){
                for(int i = 0; i < 5; i++){
                    if(arr[i][j] == '.') continue;
                    sb.append(arr[i][j]);
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(sb);
            sb.setLength(0);                // sb를 비워주는 메서드

        }
    }
}
