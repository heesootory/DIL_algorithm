import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 1; i<=n; i++) {
            String str = Integer.toString(i);
            if(str.contains("3") || str.contains("6") || str.contains("9")){
                str = str.replace("3", "-");
                str = str.replace("6", "-");
                str = str.replace("9", "-");
                str  = str.replaceAll("[0124578]", "");     //replaceAll은 정규표현식으로 문자열 변환시키는 함수.
            }

            System.out.print(str + " ");

        }

    }
}