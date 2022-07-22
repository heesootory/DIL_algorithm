import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  memoization 을 결정하는 문제
 *  dp문제는 크게
 *  1. base check(기본 조건 - 귀납법의 최소항)
 *  2. memoization : 재귀함수 고통을 덜어줄 기록.
 *  3. 재귀함수
 *
 *  로 나뉘는데, 이미 문제에서 base check와 재귀함수의 구현을 준것이다.
 *  memoization으로 나오는 결과들이 모두 계산된 뒤에 return 되므로, 모조리 저장을 해두면 점차 큰수에 가서 시간을 단축시킨다는 의미이다.
 *
 *  return 뒤에 계산(연산자)가 있을때, 모든 연산을 마치고 그 값을 return한다.
 */

public class Main {
    static int[][][] arr = new int[21][21][21];
    static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if(a > 20 || b > 20 || c > 20)
            return arr[20][20][20] = w(20, 20, 20);

        if(arr[a][b][c] != 0) return arr[a][b][c];

        if(a < b && b < c)
            return arr[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        else
            return arr[a][b][c] = w(a-1, b, c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a; int b; int c;

        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            System.out.println( "w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }

    }
}