import java.io.*;
import java.util.*;

/**
 *   순열 - 10개의 수중 3개를 뽑아 순서대로 나열
 */

public class Main {
    static List<int[]> list;
    static int cnt;
    static void comb(int[] arr, int k, int[] ans){
        if(k == 3) {
            cnt++;
            //System.out.println(Arrays.toString(ans));
            list.add(ans);
            return;
        }

        for(int i = k ; i < arr.length; i++) {
            ans[k] = arr[i];
            comb(arr, k+1, ans);
            ans[k] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        list = new ArrayList<>();
        int N = 3;
        int[] ans = new int[N];

        comb(arr, 0, ans);

        System.out.println(cnt);

//        for(int[] i : list){
//            System.out.println(Arrays.toString(i));
//        }
    }
}