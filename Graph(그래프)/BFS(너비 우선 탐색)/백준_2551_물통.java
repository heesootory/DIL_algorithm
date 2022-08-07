import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 배열을 사용해서, 그 값을 변화시키며 다시 그 배열을 큐에 저장하면서 BFS하는 문제이다.
 * 기존의 배열이 for을 돌때마다 변화하기 때문에 푸는데 해매는 큰 원인이 됬는데,
 * 배열값이 바뀌는 일이 있다면, 절대
 * int[] new_arr = origin_arr
 * 이런식으로 초기화 진행하지 않도록 하자. -> 배열을 주솟값이 저장되므로, origin의 배열도 바뀔수 있는 요소가 숨어있다.
 * 항상 배열을 재배열할때는 원소 하나하나를 다시 지정해 주자.
 */

public class Main {
    static int[] water_arr;         // 물이 든 양 배열
    static int[] vol_arr;           // 용량 배열
    static boolean[][][] visited;       // 방문 여부
    static Set<Integer> ans = new HashSet<>();      // 중복값 없애기 위해 set으로 일단 받음.

    static void check(int[] water_arr){
        Queue<int[]> q = new LinkedList<>();
        q.add(water_arr);
        visited[water_arr[0]][water_arr[1]][water_arr[2]] = true;

        while(!q.isEmpty()){
            int[] wat_arr = q.poll();

            for(int i = 0; i < 3; i++){                 
                if(wat_arr[i] != 0){            // 물이 있는 곳을 찾음.
                    for(int j = 0; j< 3; j++){
                        if(j != i && vol_arr[j] > wat_arr[j]) {     // 물을 주는곳과 받는 곳이 같으면 안되고 && 받는 곳이 꽉차있지 않는 경우.

                            int[] w_arr = new int[3];                           // 🔥 가장 해맸던 부분....🔥
                            for(int k = 0; k<3; k++) w_arr[k] = wat_arr[k];     // 🔥배열의 초기화는 항상 원소 각각을 다시 지정하기!!!!🔥
                            //int[] w_arr = wat_arr;                -> 🔥 이게 될 수 없다아~~!!!!! 🔥

                            // 물 이동시키기.  i(주는곳) -> j(받는곳)
                            int poss_move_to = vol_arr[j] - w_arr[j];      // j가 받을 수 있는 양
                            int poss_move_from = w_arr[i];                  // i가 줄 수 있는 물의 양.

                            if(poss_move_from > poss_move_to){          // 받는 곳이 꽉 채워질 경우(줄수있는양 > 받을 수 잇는 양)
                                w_arr[j] = vol_arr[j];
                                w_arr[i] -= poss_move_to;
                            }else{                                      // 주는 곳이 비워지는 경우(줄수 있는 양 <= 받을 수 있는양)
                                w_arr[j] += poss_move_from;
                                w_arr[i] = 0;
                            }

                            if (w_arr[0] == 0) ans.add(w_arr[2]);        // A물통이 비었을때, C물통의 양을 저장.

                            if (!visited[w_arr[0]][w_arr[1]][w_arr[2]]) {       // 방문 안했던 곳만 큐에 저장
                                q.add(w_arr);
                                visited[w_arr[0]][w_arr[1]][w_arr[2]] = true;
                            }
                        }
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visited = new boolean[a+1][b+1][c+1];   // 방문 여부 - 3차원 배열
        vol_arr = new int[] {a,b,c};            // 물통의 용량 배열
        water_arr = new int[] {0, 0, c};        // 물통에 들어있는 물의 양 배열

        check(water_arr);
        List<Integer> ans_list = new ArrayList<>(ans);      // 오름차순으로 출력하기 위해 set -> list
        Collections.sort(ans_list);
        for(int i : ans_list) System.out.print(i + " ");
    }
}

