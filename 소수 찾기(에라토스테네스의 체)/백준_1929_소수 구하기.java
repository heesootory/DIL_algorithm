import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        int n = s.nextInt();

        Boolean[] arr = new Boolean[n+1];
        Arrays.fill(arr, true);     //전체 배열을 하나로 true로 초기화
        arr[0] = false;
        arr[1] = false;     // 0과 1은 소수 x.

        // 에라토스테네스의 체.
        for(int i = 2 ; i < Math.sqrt(arr.length); i++){        // 구하고자는 수의 제곱근까지에 해당하는 수들의 배수만 확인하면 됨.
            if(arr[i]){
                for(int j = i; j < arr.length; j += i) {
                    if(j == i) continue;        // 배수를 위한 작은 소수는 '소수'이니까 제외.
                    arr[j] = false;
                }
            }
        }

        for(int i = 0; i < m; i++) arr[i] = false;

        for(int i = m ; i <=n; i++)
            if(arr[i]) System.out.println(i);


    }
}