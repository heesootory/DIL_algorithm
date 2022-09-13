# 17626 - Four Squares


## 아이디어

* 완탐 - 백트래킹으로, depth가 4이하인 조합의 수들을 모두 탐색해서 그중 길이가 짧은 값만 저장.

* dp : 규칙이 쉽게 보이진 않는다. 게다가 그 중 최솟값을 찾는 규칙은 한단계 더나아가야함.
    - 일단 수들을 모두 적어보아야 한다! 적어도 20까지....
    - 규칙이 보일 듯 말듯....계속 생각해야한다!
    - 또한 제곱수들로 이루어진 조합중에 최솟값을 찾는 문제이므로, 큰수 부터 시작되는 제곱수의 조합들 이외에도 가능한 모든 조합을 하나의 숫자에도 여러개 적어보고 모든 통용규칙을 찾아내야만 한다.. ㅠ


## 코드 - 백트래킹으로 완전탐색

```java
import java.io.*;
import java.util.*;


public class Main {
    static int[] arr;           // 해당 인덱스의 제곱수 배열.
    static int min = Integer.MAX_VALUE;
    static void dfs(int idx ,int N, int start){
        if(N == 0) {
            min = Math.min(min, idx);
            return;
        }
        if(idx >= 4) return;

        for(int i = start; i > 0; i--){
            dfs(idx + 1, N - arr[i], i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[250];

        int start = 0;
        for(int i = 1; i < arr.length; i++){
            arr[i] = i*i;
            if(arr[i] > N) {
                start = i;
                break;
            }
        }
        dfs(0, N, start-1);
        System.out.println(min);

    }
}


```

## 코드 - dp

```java

```import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[50001];

        dp[1] = 1;
        // dp: bottom - up 방식
        for(int i = 2; i <= N; i++){
            int min = Integer.MAX_VALUE;

            // i에서 i보다 작은 제곱수에서 뺀 dp[i-j*j]+1 중에 더 작은값을 저장.
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);

    }
}

