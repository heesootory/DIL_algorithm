# 3613 - s3 - Java vs C++


## 아이디어

* 반례가 중요!


## 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static String str;
    static boolean error(){
        if(str.contains("__")) return true;
        if(str.charAt(0) >= 65 && str.charAt(0) <= 90) return true;
        if(str.charAt(str.length()-1) == '_') return true;
        if(str.charAt(0) == '_') return true;
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        ArrayList<Integer> underBars = new ArrayList<>();
        ArrayList<Integer> upperCases = new ArrayList<>();

        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '_') underBars.add(i);
            else if(65 <= c && c <= 90) upperCases.add(i);
        }

        StringBuilder sb = new StringBuilder();

        if(underBars.size() > 0 && upperCases.size() > 0) System.out.println("Error!");
        else if(error()) System.out.println("Error!");
        else{
            if(underBars.size() > 0) {
                boolean flag = false;
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '_') flag = true;
                    else if(flag) {
                        sb.append((char)(str.charAt(i) - 32));
                        flag = false;
                    }
                    else sb.append(str.charAt(i));
                }
            }
            else{
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) >= 65 && str.charAt(i) <= 90) sb.append("_").append((char)(str.charAt(i) + 32));
                    else sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}

```