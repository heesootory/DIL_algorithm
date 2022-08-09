import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이중 우선순위 큐 + 해시맵  -> (힙정렬) + (해시정렬)
 *
 * 이중 우선순위 큐 : 최대값과 최솟값의 최신화를 가장 빠른 시간 복잡도로 정리 가능.
 *
 * 배울만한 점
 * 1. 이중 큐를 사용하기 때문에, 한쪽에서 값을 꺼내어 확인했을 때, 다른 한쪽에서는 그 값이 남아있다.
 * 그걸 해시맵을 이용해서 원소와 갯수를 파악한다.
 *
 * 2. 우선순위 큐를 오름차순으로 정의 할때,
 *      - Collections.reverseOrder()
 *      - Comparator를 재정의 해서 사용한다.
 *          - 이때가 문제인데, 이문제에서,
 *          - return o2 - o1을 하면 오답이 되고,
 *          - return o2.compare(o1)을 하면 정답이되더라...
 *
 *  why??
 *  o2 - o1은 예를 들어 (-21억) - (3억)이 들어온다고 가정하면, -24억이 되어버리고,
 *  int의 범위를 overflow가 되어버리므로, 양수로 바뀌어 버린다.
 *
 *  o2.compareTo(o1)함수를 사용하면 그 오버플로우를 처리해준다.
 *  -> o2 - o1 같은 연산을 return하면 큰 음수 가 나올 수 있지만,
 *  return (x < y) ? -1 : ((x == y) ? 0 : 1);
 *  식의 return을 사용하며 오버플러우 방지
 *
 *  3. Integer.MIN_VALUE 는 -를 붙여도 바뀌지 않음.
 *
 */




public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0){
            PriorityQueue<Integer> ascending_pq  = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);    //가능
                }
            });
//            PriorityQueue<Integer> ascending_pq  = new PriorityQueue<>(Collections.reverseOrder());       // 가능
//            PriorityQueue<Integer> ascending_pq  = new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;           // 불가능
//                }
//            });
            PriorityQueue<Integer> descending_pq  = new PriorityQueue<>();

            Map<Integer, Integer> map = new HashMap<>();
            // 값의 존재여부, 갯수 등은 map으로만 파악한다.
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                char c = (st.nextToken()).charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(c == 'I'){
                    ascending_pq.add(n);
                    descending_pq.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    // map 에 저장되는 값은 <n, n의 갯수>
                }
                else{
                    if(map.size() == 0) continue;

                    Queue<Integer> que = (n == 1) ? ascending_pq : descending_pq;
                    q_remove(que, map);     // 반환값이 있어도 안받아도 됨...
                }
                //System.out.println(map);
            }
            //System.out.println("ans : " + map);
            if(map.size() == 0) System.out.println("EMPTY");
            else {
                int max = q_remove(ascending_pq, map);
                int min = (map.size() == 0) ? max : q_remove(descending_pq, map);
                // maxm를 구할때 map의 사이즈가 바낄 가능성 있으므로, 다시 한번 검사.

                System.out.println(max + " " + min);
            }
        }

    }
    static int q_remove(Queue<Integer> q, Map<Integer, Integer> map){
        // 주의할점! remove시, 받아온 큐에서도 삭제, map에서도 감소혹은 삭제된다.
        int k = 0;
        while(!q.isEmpty()){
            k = q.poll();

            int cnt = map.getOrDefault(k, 0);
            if(cnt == 0) continue;      // 그냥 큐만 삭제

            if(cnt == 1) map.remove(k);     // 한개 남은거면 map에서도 삭제.
            else map.put(k, cnt -1);        // 맵의 갯수 감소
            break;
        }
        return k;
    }
}
