import java.io.*;
import java.util.*;

/**
 *  "우선순위 큐" PriorityQueue
 *  - 우선순위 큐는 내가 지정한 가중치가 중요한 순서로, 데이터가 입력을 받을대마다 (힙)정렬되어 갱신된다.
 *   "Comparable" 인터페이스를 이용해, compareTo을 내림차순으로 정렬하여,
 *   우선순위 큐 안에 들어가는 데이터를 가중치가 작은 순으로 배치되게 힙 정렬한다.
 *   (힙 정렬은 이진트리를 이용한 정렬 - 퀵정렬 만큼 빠름)
 *
 *   - 문제 아이디어 -
 *   우선순위 큐에서 poll 된 값으로 인접한 지점들을 조사하고,
 *   현재까지의 가중치와 다음 지접으로 갈 경로의 가중치를 더해서 이미 저장된 다음 지점의 최솟값보다
 *   작을시에만, 우선순위 큐에 들어간다.
 *   한 마디로 현재 있는 값보다 작은 최솟값의 가능성이 있는 값들만 큐에 들어가게 되는데,
 *   들어갈때 마다 큐에서는 힙정렬로 최솟값이 젤 먼저 나오게 됨으로, 다음 지점의 가중치가 나오면,
 *   무조건 check=true로 방문처리하고, 그게 최솟값이 된다.
 *   그리고 처음 경로에 저장된 인접행렬들의 가중치는 모두 각각의 경로마다의 가중치이므로,
 *   큐에는 Pair(다음 경로, 그 경로까지의 최소 가중치)로 집어 넣는다.
 *   그래야 그 다음 경로에서도 최솟값들끼리 비교가 가능하다.
 */

class Pair implements Comparable<Pair>{
    int to;
    int weight;
    public Pair(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    // Pair 객체를 어떤 배열이나 우선순위 큐등 정렬이 필요한 곳에 넣었을때,
    // 가중치를 우리가 커스터마이징 할 수있도록 구현
    @Override
    public int compareTo(Pair o){
        return weight - o.weight;   // 내림차순으로 정렬
    }
}

public class Main {
    static ArrayList<ArrayList<Pair>> root;     // 경로 저장
    static int city;
    static int[] min_cost;      // index까지 오는 최소 비용
    static boolean[] check;     // 방문 여부 확인

    static void dijkstra(int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        min_cost[start] = 0;

        while(!pq.isEmpty()){
            Pair arrive = pq.poll();

            //우선순위 큐에 의해, 입력 받는 값들중 항상 제일 가중치가 낮는 도착지점의 경로는 이미 true로 바껴있다.
            if(!check[arrive.to]){
                check[arrive.to] = true;

                for(Pair next : root.get(arrive.to)){
                    if(!check[next.to] && min_cost[next.to] > (min_cost[arrive.to] + next.weight)){
                        // 다음으로 갈 지점이 false이고
                        // 현재 가중치(min_cost[arrive.to])와 다음 갈 지점의 경로의 가중치의 합이,
                        // 갈 지점의 가중치보다 작을때만 큐에 저장.
                        min_cost[next.to] = (min_cost[arrive.to] + next.weight);
                        pq.add(new Pair(next.to, min_cost[next.to]));
                        //다음에 갈수 있는 경로는 어차피 Pair의 to로 저장되어있으므로, 가중치만 최솟값으로 계속 들고가는 방식.
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        root = new ArrayList<>();
        for(int i =0; i<= city; i++){       // city 만큼의 동적배열 생성.
            root.add(new ArrayList<>());
        }
        check = new boolean[city + 1];
        min_cost = new int[city + 1];
        Arrays.fill(min_cost, Integer.MAX_VALUE);

        while(bus-- > 0){
            st = new StringTokenizer(br.readLine());

            int form = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            root.get(form).add(new Pair(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(min_cost[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}