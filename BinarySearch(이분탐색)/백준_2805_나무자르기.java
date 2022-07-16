import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int[] trees = new int[n];

        for(int i = 0; i< n; i++)trees[i] = s.nextInt();
        Arrays.sort(trees);
        int right = trees[n-1];         //나무길이 중 최댓값
        int left = 0;
        int mid = right;                //최댓값으로 먼저 시작

        while(left < mid){
            long sum = 0;

            for(int i : trees){
                if(mid < i) sum += (i - mid);       //잘린 나무부분들 더한 총합.
            }

            // 총합에 따라 이분탐색.
            if(sum < m) right = mid;
            else left = mid;

            mid = (right + left)/2;
        }

        System.out.println(mid);
    }
}