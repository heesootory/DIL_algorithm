# 9663 - N-Queen


## 아이디어

* 시간초과와 메모리관리를 잘해야하는 것이 관건.

* queen_row라는 일차원 배열 하나에 모든걸 전부 다 담고 확인할수 있게 묶어서 하나의 일차원 배열로 활용할 수 있는 모든 것을 확인해. 메모리관리를 하는 것이 중요하다.
    - 인덱스 (idx) : 행
    - 원소값 : 열
    - 대각선 체크는 행과 열의 절대값 차이를 이용.



## 코드

```java
import java.io.*;
import java.util.*;


public class Main {
    static int N, cnt;
    static int[] queen_row;
    static boolean check(int idx, int now){         // 이번에 놓을 행과 열 - idx, now
        for(int i = 0 ; i < idx; i++){
            if(Math.abs(idx - i) == Math.abs(queen_row[i] - now)) return false;
            if(queen_row[i] == now) return false;
        }
        return true;
    }

    static void dfs(int idx){       // idx 가 퀸이 위치할 행(row)
        if(idx == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!check(idx, i)) continue;
            queen_row[idx] = i;
            dfs(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen_row = new int[N];

        dfs(0);
        System.out.println(cnt);
    }
}


```