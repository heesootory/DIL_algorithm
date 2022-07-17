import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] edge = new ArrayList[101];
    static boolean[] person;         //통화가 이미 연결됬는지 확인하는 bool배열 : true -> 통화 가능.

    static int BFS(int s){
        Queue<Integer> q = new LinkedList();
        q.add(s);
        int max = 0;

        while(q.isEmpty() == false){
            int q_size = q.size();
            max = 0;                            // 계층마다 최대값 초기화.

            for(int i =0 ; i < q_size; i++){        // bfs에서 그래프 계층별로 받아들이는 방법.
                int f = q.peek(); q.poll();
                if(f > max) max = f;                //계층마다 최대값 구해주기.
                for(int j : edge[f]){
                    if(person[j]){
                        q.add(j); person[j] = false;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //reader선언 - 빠른 입력 받기
        StringTokenizer st;
        int t = 10;     // 이문제 input이 없어서 내가 지정해줌... swea 이상한 문제..
        int _case = 1;

        while(t-- > 0){
            for(int i = 0; i< edge.length; i++) edge[i] = new ArrayList();      // 배열 초기화!!
            person = new boolean[101];                      // 통화 중인지 확인하는 bool배열도 초기화!!
            //-> testcase가 몇개만 맞는다면 초기화를 고려해봐라...자주 깜박하는 것.

            st = new StringTokenizer(br.readLine());

            int data = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            int[] data_arr = new int[data];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < data; i++) {
                data_arr[i] = Integer.parseInt(st.nextToken());           // 데이터 입력받기
                person[data_arr[i]] = true;             // true - 통화 가능
            }
            for(int i = 0; i < data; i+= 2) edge[data_arr[i]].add(data_arr[i+1]);     //데이터 edge에 분류.

            int ans = BFS(start);
            System.out.println("#" + _case + " " + ans);

            _case++;
        }

    }
}
