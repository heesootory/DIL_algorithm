package 힙;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());      // 동일한 방법.

        int n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if(x == 0){
                if(pq.size() == 0) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
                pq.add(x);
            }
        }

    }
}

