import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
 
            Queue<Integer> q = new LinkedList<>();
 
            for(int i =0; i< 8; i++) {
                int x = Integer.parseInt(st.nextToken());
                q.add(x);
            }
 
            boolean check = false;
            while(true){
                for(int i = 1; i<= 5; i++){
                    int x = q.poll();
                    x -=i;
                    if(x <= 0){
                        q.add(0);
                        check = true;
                        break;
                    }
                    q.add(x);
                }
                if(check) break;
            }
            System.out.print("#" + t + " ");
            for(int i : q) System.out.print(i + " ");
            System.out.println();
        }
 
    }
}