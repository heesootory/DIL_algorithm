import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  🐶 부동 소수점 오차
 *
 *  변수에 실수형을 저장하면 오차가 발생.
 *  실수형은 소수가 2진수로 저장되기 때문에 이를 나타낼수 없을 경우 가장 근사한 값을 저장하기 때문..
 *
 *  예를 들어, double형 변수에 0.58을 저장하고 *100을 한다면 58이 나온다고 생각할 수 있지만 컴퓨터는 이를 저장하지 못하고 0.579999999로 저장하기 때문에
 *  실제로 57이 반환.
 *
 *  이 문제에서는 퍼센트를 구하는 공식에서 (left*100/right)인데 이 값은 (left/right*100) 과 결과가 다르게 나온다.
 *  
 *  근데 왜 하나는 맞고 하나는 틀린가??????? why???
 */

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        double left = (double)y;
        double right = (double)x;
        double origin = Math.floor(left * 100/right);
        double ans = 0.0;
        int cnt = 0;

        if (origin >= 99) {         // 99퍼센트이상은 더이상 올라갈수 없으므로 -1 출력
            System.out.println(-1);
        }
        else{
            while(true){
                left++; right++;
                ans = Math.floor(left * 100/right);
                cnt++;
                if(ans - origin >= 1) break;
            }
            System.out.println(cnt);
        }

    }
}