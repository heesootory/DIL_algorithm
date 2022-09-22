import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] ans;
    static List<Integer>[] list;
    static boolean[] visited;

    static void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        queue.add(idx);
        visited[idx] = true;
//        int cnt = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            ans[idx]++;
            for(int i : list[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
//        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) list[i] = new ArrayList<>();
        ans = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        int max = 0;
        for(int i = 1; i <= N; i++){

            bfs(i);
            max = Math.max(max, ans[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
//            System.out.print(ans[i] + " ");
            if(ans[i] == max) {
                sb.append(i);
                sb.append(" ");
            }
        }
        System.out.println(sb);
//        bw.flush();
//        bw.close();
    }
}