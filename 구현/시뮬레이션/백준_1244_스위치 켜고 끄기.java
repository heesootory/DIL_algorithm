import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  "모 아니면 도" 배열은 boolean도 가능하지만, -1과 1을 이용하면 계산하기 편리.
 *
 */


public class test {
    static int[] arr;
    static void arr_change(int bg, int sw){
        if(bg == 1){
            for(int i = sw; i < arr.length; i += sw) arr[i] *= -1;
        }else{
            arr[sw] *= -1;
            int i = sw-1;
            int j = sw+1;
            while(i >= 0 && j < arr.length) {
                if(arr[i] == arr[j]) {
                    arr[i--] *= -1;
                    arr[j++] *= -1;
                }
                else break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<n+1; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = (x == 0) ? -1 : x;
        }
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int bg = Integer.parseInt(st.nextToken());
            int sw = Integer.parseInt(st.nextToken());
            arr_change(bg, sw);
        }

        int cnt = 0;
        for(int j =1; j< n+1; j++) {
            cnt++;
            if(arr[j] == -1) arr[j] = 0;
            System.out.print(arr[j] + " ");
            if(cnt % 20 == 0) System.out.println();
        }
    }
}
