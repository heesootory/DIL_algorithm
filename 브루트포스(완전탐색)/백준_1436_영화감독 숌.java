import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer n = Integer.parseInt(st.nextToken());
        Integer i = 665;
        while(n > 0){
            i++;
            String str = Integer.toString(i);
            if(str.contains("666")){
                n--;
            }
        }
        System.out.println(i);

    }
}
