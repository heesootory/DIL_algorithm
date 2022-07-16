import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		int _case = 1;
		while(t-- > 0) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i< arr.length; i++) arr[i] = s.nextInt();
			long sum = 0;
			int big = arr[n-1];
			for(int i = n-2; i>=0; i--) {
				if(arr[i] > big) big = arr[i];
				else sum += (big - arr[i]);
			}
			System.out.println("#"+ _case + " " + sum);
			_case++;
		}

	}
}
