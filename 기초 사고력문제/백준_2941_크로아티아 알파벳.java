import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int i = 0;
        int cnt = 0;
        while(i < str.length()){
            char x = str.charAt(i);

            if(i > 0){// 🔥🔥 항상 배열의 시작과 끝에  outofIndex 를 주의!!!! 🔥🔥
                if(x == '='){
                    char y = str.charAt(i-1);
                    if((i-2) >= 0 && str.substring(i-2, i).equals("dz")) cnt -= 2;
                    // 🔥🔥 항상 배열의 시작과 끝에  outofIndex 를 주의!!!! 🔥🔥
                    else if(y == 'c' || y == 's' || y == 'z') cnt--;
                }
                else if(x == '-'){
                    char y = str.charAt(i-1);
                    if(y == 'c' || y == 'd') cnt--;
                }
                else if(x == 'j'){
                    char y = str.charAt(i-1);
                    if(y == 'l' || y == 'n') cnt--;
                }
            }

            cnt++;
            i++;

        }

        System.out.println(cnt);

    }
}
