import java.io.*;
import java.util.*;


public class Main {
    static int minus;
    static int one;
    static int zero;
    static void divide(int[][] arr, int left, int top, int size){
        if(count(arr, left, top, size)) return;
        int three = size/3;
        divide(arr, left, top, three);
        divide(arr, left + three, top, three);
        divide(arr, left + three * 2, top, three);
        divide(arr, left, top + three, three);
        divide(arr, left + three, top + three, three);
        divide(arr, left + three * 2, top + three, three);
        divide(arr, left, top + three * 2, three);
        divide(arr, left + three, top + three * 2, three);
        divide(arr, left + three * 2, top + three * 2, three);

    }
    static boolean count(int[][] arr,int left, int top, int size){
        int start = arr[top][left];
        for(int i = top; i < top + size; i++){
            for(int j = left; j < left + size; j++){
                if(arr[i][j] != start) return false;
            }
        }
        switch(start){
            case -1: minus++; break;
            case 0 : zero++; break;
            case 1: one++; break;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(arr, 0, 0, N);
        System.out.println(minus + "\n" + zero + "\n" + one);

    }
}

