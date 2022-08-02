import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for(int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);             // A배열은 오름차순으로 정렬 -> 기준잡기

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());

            int left = 0;       //index
            int right = n-1;    //index
            if(A[right] < b) continue;      // A배열의 최댓값보다 크다면 이분탐색x -> 0으로 놔둠

            while(left <= right){           // 이분탐색
                int mid = (left + right ) / 2;
                if(A[mid] < b) left = mid + 1;
                else if(A[mid] > b) right = mid - 1;
                else {
                    arr[i] =1;
                    break;
                }
            }

        }
        for(int i : arr) System.out.println(i);

    }
}
