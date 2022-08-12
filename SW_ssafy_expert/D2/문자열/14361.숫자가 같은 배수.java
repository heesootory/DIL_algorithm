import java.io.*;
import java.util.*;

/**
 * 숫자의 갯수가 같다면 같은 수배열의 순서만 바꾼것과 같은 지 확인은 가능하다.
 *
 */


public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int norm = Integer.parseInt(st.nextToken());
            int n = norm;

            int[] arr = new int[10];
            boolean check = false;
            
            // 주의할곳! ->  while문이후 n 이 변하므로, 수를 따로 저장하기
            while(n > 0){
                arr[n % 10]++;
                n /= 10;
            }
            
            // 재배열해서 나올 수 있는 최대의 수
            int max = 0;
            for(int i = 9; i >= 0; i--){
                for(int j = arr[i]; j > 0; j--){
                    max *= 10;
                    max += i;
                }
            }

            int m = norm;

            while(m < max){
                int[] compare = new int[10];        
                // 매 숫자마다 새로운 배열에 체크해야 하므로, while안에서 초기화
                m += norm;
                int l = m;
                while(l > 0){
                    compare[l % 10]++;
                    l /= 10;
                }
                
                // 구성하는 숫자들의 갯수가 같으면 재배열 수로 생각
                int cnt = 0;
                for(int k = 0; k< 10; k++){
                    if(arr[k] == compare[k]) cnt++;
                }

                if(cnt == 10){
                    check = true; break;
                }

            }

            if(check) System.out.println("#" + t + " " + "possible");
            else System.out.println("#" + t + " " + "impossible");

        }
    }
}
