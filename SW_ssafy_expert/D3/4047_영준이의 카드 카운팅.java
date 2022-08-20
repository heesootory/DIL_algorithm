import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++) {
            int[][] card_arr = new int[4][14];

            String str = br.readLine();
            int len = str.length();

            for(int i = 0; i < len; i += 3){
                String card = str.substring(i, i+3);
                char c = card.charAt(0);
                int num = (card.charAt(1) - '0') * 10 + (card.charAt(2) - '0');
                switch(c){
                    case 'S': card_arr[0][num]++; break;
                    case 'D': card_arr[1][num]++; break;
                    case 'H': card_arr[2][num]++; break;
                    case 'C': card_arr[3][num]++; break;
                }
            }

            boolean check = true;
            int[] ans_arr = new int[4];
            for(int i = 0; i < card_arr.length; i++){
                int cnt = 0;
                for(int j = 1; j < card_arr[i].length; j++){
                    if(card_arr[i][j] > 1){
                        check = false; break;
                    }
                    cnt += card_arr[i][j];
                }
                ans_arr[i] = (13 - cnt);
            }

            if(check){
                System.out.printf("#%d ",t);
                for(int i : ans_arr) System.out.print(i + " ");
                System.out.println();
            }else System.out.println("#" + t + " ERROR");

        }
    }
}
