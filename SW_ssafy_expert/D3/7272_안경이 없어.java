import java.io.*;
import java.util.*;

public class Main {

    static boolean check(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        for(int i = 0; i < str1.length(); i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if(c2 == 'B' || c1 == 'B'){
                if(c1 != c2) return false;
            }

            int contain1 = "ADOPQR".indexOf(c1);
            int contain2 = "ADOPQR".indexOf(c2);

            if((contain1 != -1 && contain2 == -1) || (contain1 == -1 && contain2 != -1) ) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++) {
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            String ans = (check(str1, str2)) ? "SAME" : "DIFF";

            System.out.printf("#%d %s\n", t, ans);

        }
    }
}
