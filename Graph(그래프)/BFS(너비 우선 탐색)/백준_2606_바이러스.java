import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int num;
    static ArrayList<Integer>[] edge = new ArrayList[101];      // 아직 num이 들어오지 않았으므로, 배열의 길이를 num으로 하면 안됨.
    static boolean[] check = new boolean[101];
    static int cnt = 0;

    static void BFS(int s){
        Queue<Integer> q = new LinkedList();
        q.add(s);
        check[s] = false;

        while(!q.isEmpty()){
            int f = q.peek(); q.poll();
            for(int i : edge[f]){
                if(check[i] == true){
                    q.add(i);
                    cnt++; check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for(int i = 0; i< 101; i++) edge[i] = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        int _case = Integer.parseInt(br.readLine());

        Arrays.fill(check,1, num+1, true);      //범위 지정하여 컴퓨터 갯수 만큼만 true로 지정.

        for(int i = 0; i<_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b); edge[b].add(a);
        }

        BFS(1);
        System.out.println(cnt);
    }
}
