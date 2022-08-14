import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  dfs는 트리가 아닌, 경로로 생각해야 한다.
 *
 *  언듯 보면 이문제는 트리의 구조와 매우 유사해서, dfs구분이 없다면, 트리로만 접근했다가 구현이 쉽지 않아 질 수 있다.
 *
 *  경로 탐색에서도 이문제와 같이 다양한 많은 수의 가지가 있지 않은 경로배열은 dfs가 효과적이고, 직관적이다.
 *  또한 최단 경로를 구하는 문제가 아니기 때문에, bfs를 사용할 필요는 더욱이 없어 보인다.
 *
 *  ! 경로 탐색 유형인 dfs와 bfs는 모두 온길로 다시 돌아 가지 않게끔 하기 위해, visited배열(이미 확인 한곳 다시 가지 않게)이 필요하다.
 */

public class test {

    static ArrayList<Integer>[] treeNode;
    static boolean[] visited;
    static int ans = -1;
    static void dfs(int start, int end, int cnt){
        if(start == end){
            ans = cnt;
            return;
        }

        visited[start] = true;
        for(int i : treeNode[start]){
            if(!visited[i]){
                dfs(i, end, cnt+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        treeNode = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) treeNode[i] = new ArrayList();
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());       // 출발지
        int end = Integer.parseInt(st.nextToken());         // 도착지

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i<m; i++){               // 인접행렬 만들기
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            treeNode[x].add(y);
            treeNode[y].add(x);
        }

        dfs(start, end, 0);

        System.out.println(ans);


    }
}
