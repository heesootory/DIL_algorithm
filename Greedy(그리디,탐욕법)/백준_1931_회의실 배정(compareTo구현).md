# 1931 - 회의실 배정


## 아이디어

* 종료시간을 기준으로 빨리 끝나는 것부터 오름차순으로 정렬

* 그다음 종료시간이 같은것은 시작시간이 빠른것 부터 오름차순으로 정렬.
    - 시작시간과 종료시간이 같은 회의가 같은 종료시간인 회의들 중에 먼저 오게 된다면, 다른 회의들이 불가능해 진다.
    - 예를 들어, 미팅1(4시 시작, 8시 종료)가 먼저 배치되면, 미팅2(8시 시작, 8시 종료)가 둘다 배정될 수 있지만,
    - 미팅2가 먼저 배정되어 버리면, 미팅1이 뒤에 배치되는 것은 불가능 하기 때문이다.


## 코드

```java
import java.io.*;
import java.util.*;

public class Main{
    static class meeting implements Comparable<meeting>{
        int s, e;
        meeting(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(meeting o){
            // 시작시간이 작은것부터 오름차순, 시작시간이 같다면 끝나는 시간이 작은것 순으로 오름차순
            if(this.e == o.e) return this.s - o.s;
            else return this.e - o.e;
        }
    }
    static int N;
    static Queue<meeting> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new meeting(start, end));
        }

        int cnt = 1;
        int norm = queue.poll().e;

        while(!queue.isEmpty()){
            meeting m = queue.poll();
            if(m.s >= norm){
                cnt++;
                norm = m.e;
            }
        }

        System.out.println(cnt);

    }
}
```