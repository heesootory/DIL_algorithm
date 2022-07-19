import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  배열의 처음 부터 하나씩 합과 최댓값을 동시에 갱신해 나간다.
 *  합을 계속 더해나가면서, 최댓값보다 크면 최댓값을 합으로 갱신하고, 합이 음수일때는 합을 0으로 초기화해서 다시 더해나감.
 *  위의 방식은 배열의 원소가 전부 음수일때는 0이 나오게 되므로, reture이 0으로 나올경우 음수들중의 최댓값을 구해준다.
 */

public class Solution {
    static int[] arr;
    static int solved_max(){
        int max = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = s.nextInt();

        if(solved_max() == 0){
            Arrays.sort(arr);
            System.out.println(arr[arr.length-1]);
        }else{
            System.out.println(solved_max());
        }



    }
}
