import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<String> list = new ArrayList<>();

        String word = "";
        boolean bracket = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '<') {
                list.add(word);
                word = "";
                bracket = true;
                word += c;
            }
            else if(c == '>'){
                bracket = false;
                word += c;
                list.add(word);
                word = "";
            }
            else if(c == ' ' && !bracket) {
                list.add(word);
                list.add(String.valueOf(c));
                word = "";
            }
            else{
                word += c;
            }
            if(i == str.length() - 1) list.add(word);       // 문장의 맨마지막일때 모았던 단어를 list에 저장.
        }
        boolean[] check_arr = new boolean[list.size()];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).length() == 0) continue;         // < 앞에 아무것도 없는 문자열이 list에 저장되있음.
            if(list.get(i).charAt(0) == '<') check_arr[i] = true;
        }

        String ans = "";
        for(int i = 0; i< list.size(); i++){
            String st = list.get(i);
            if(!check_arr[i]){
                for(int j = st.length()-1; j >= 0; j--){
                    ans += st.charAt(j);
                }
            }
            else{
                for(int j = 0; j < st.length(); j++){
                    ans += st.charAt(j);
                }
            }

        }

        System.out.println(ans);

    }
}
