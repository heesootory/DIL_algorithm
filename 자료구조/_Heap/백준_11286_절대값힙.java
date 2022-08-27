package 힙;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){      //comparator 은 익명클래스로 구현
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;        // 절대값이 같다면, 원래수의 내림차순으로
                else return Math.abs(o1) - Math.abs(o2);                // 절대값이 다르다면, 절대값의 내림차순으로.
            }
        });

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

