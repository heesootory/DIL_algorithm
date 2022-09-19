import java.io.*;
import java.util.*;


public class Main {
    static int N, A, D;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == A) list.add(i);        // 탐색을 시작할 지점들만 따로 저장.
        }

        int max = 0;
        for(int i : list){
            int start = A;
            int cnt = 0;
            for(int j = i; j < N; j++){
                if(arr[j] == start) {       // 해당수를 찾을대마다.
                    start += D;         // start를 등차만큼 올리고
                    cnt++;              // 카운트
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);

    }
}