import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = s.nextInt();     // i : 사람의 번호, arr[i] : 왼쪽에 자신보다 큰수의 갯수

        int[] num = new int[n];         // 사람을 정렬할 배열.

        for(int i =  0; i < n; i++){
            int person = i + 1;     // 사람의 번호
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(num[j] == 0) cnt++;      // 0(빈배열)의 갯수를 카운트 -> 자신보다 큰 수가 들어갈 공간의 갯수를 카운트
                if(cnt == arr[i]+1) {       // 공간의 갯수가 일치하면 그 다음 빈칸에 자신을 집어넣고, break.
                    num[j] = person;
                    break;
                }

            }
        }

        for(int i : num) System.out.print(i + " ");


    }
}