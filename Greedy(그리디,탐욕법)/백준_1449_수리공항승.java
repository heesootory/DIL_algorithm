import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int l = s.nextInt();        //테이프의 길이
        l -= 1;         // 테이프의 길이에서 양쪽 0.5를 없애버림 -> 딱맞게 붙였을때 막는걸로 가정.
        int[] arr = new int[n];

        for(int i = 0; i< n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);

        int cnt = 0;        //테이프의 갯수
        int start = arr[0];     //파이프의 새는 처음 구멍
        for(int i = 1; i< n; i++){
            if(l < arr[i] - start){     //구멍의 사이의 간격이 테이프 길이를 초과했을때
                cnt++;
                start = arr[i];
            }
        }
        System.out.println(cnt+1);      //마지막 테이프 추가



    }
}