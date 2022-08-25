package JUNGOL_정올;

public class 1205_조커 {
    
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1002];
        List<Integer> num_list = new ArrayList<>();
        List<Integer> blank_list = new ArrayList<>();

        int zero = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            int idx = Integer.parseInt(st.nextToken());
            if(idx == 0) zero++;
            else check[idx] = true;
        }

        // 연속적인 숫자 집합의 갯수 배열
        int num = 0;
        for(int i = 0; i < check.length-1; i++){
            if(check[i]) num++;
            if(check[i] && !check[i+1]) {
                num_list.add(num);
                num = 0;
            }
        }
        // 공백의 집합의 갯수 배열
        int blank = 0;
        for(int i = 0; i < check.length-1; i++){
            if(!check[i]) blank++;
            if(!check[i] && check[i+1]) {
                blank_list.add(blank);
                blank = 0;
            }
        }
       
        num_list.add(0);num_list.add(0);
        blank_list.add(0);

        int max = 0;
        if(zero != 0 || blank_list.size() > 1){
            for(int i = 1; i < blank_list.size(); i++){
                if(blank_list.get(i) <= zero){
                    int m = num_list.get(i) + num_list.get(i-1) + zero;
                    max = Math.max(max, m);
                }
            }
        }else {
            for(int i = 0; i < num_list.size(); i++){
                max = Math.max(max, num_list.get(i));
            }
        }
        System.out.println(max);
    }
}