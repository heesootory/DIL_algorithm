import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#" + t + " ");
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            String[] word = str.split(" ");

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            boolean even = (n % 2 == 0);
            int len = even ? n/2 : n/2+1;

            for(int i = 0; i < n ; i++){
                if(i < len) list1.add(word[i]);
                else list2.add(word[i]);
            }

            for(int i = 0; i < len; i++){
                bw.write(list1.get(i));
                bw.write(" ");
                if(i == len -1 && !even) break;
                bw.write(list2.get(i));
                bw.write(" ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}
