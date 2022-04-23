import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] edge = new ArrayList[1001];
    static boolean[] check = new boolean[1001];

    static void DFS(int n){
        if(check[n] == true) return;

        check[n] = true;
        System.out.print(n + " ");
        for(int i : edge[n]){
            if(check[i] == false) DFS(i);
        }
    }

    static void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;

        while(q.isEmpty() == false){
            int f = q.peek();
            q.poll();
            System.out.print(f + " ");
            for(int i : edge[f]){
                if(check[i] == false) {
                    q.add(i); check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i< 1001; i++) edge[i] = new ArrayList();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(); int M = s.nextInt(); int v = s.nextInt();

        while(M-- > 0){
            int a = s.nextInt();
            int b = s.nextInt();
            edge[a].add(b);
            edge[b].add(a);
        }

        for(int i =0 ; i<= N; i++) Collections.sort(edge[i]);
        DFS(v);
        for(int i =0 ; i<= N; i++) check[i] = false;
        System.out.println();
        BFS(v);

    }
}