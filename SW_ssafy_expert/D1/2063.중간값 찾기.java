import java.util.*;

class Solution{

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);
        System.out.println(arr[n/2]);

    }
}
