import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 이분탐색
 *
 * 이분 탐색의 과정 속에서 가장 중요한 부분은 젤 마지막에 left와 right의 값이다.
 * left와 right가 마지막에 true영역에 있느냐, false 영역에 있느냐만 판단이 되면 쉽게
 * 구하고자하는 범위의 최소값 혹은 최댓값을 구할 수 있다.
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] a_arr = new int[a];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i< a; i++) a_arr[i] = Integer.parseInt(st.nextToken());
            int[] b_arr = new int[b];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i< b; i++) b_arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(b_arr);

            int cnt = 0;
            for(int i = 0; i< a_arr.length; i++) {
                int norm = a_arr[i];

                int left = 0;
                int right = b_arr.length-1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (b_arr[mid] < norm) left = mid + 1;
                    else right = mid - 1;
                }

                cnt += left;
            }
            System.out.println(cnt);
        }
    }
}

