import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int check(int mid){
        int cnt = 0;
        int money = mid;
        for(int i = 0; i < arr.length; i++){
            if(i == 0) cnt++;           // 첫날은 돈을 무조건 한번 인출해야함.
            if(arr[i] <= money) money -= arr[i];        // 남은 금액 >= 사용할 금액 : 빼주기만 함.
            else{                       // 남은 금액 < 사용할 금액 : 돈을 mid값으로 다시 초기화 시키고(인출함) 값을 빼줌
                cnt++;
                money = mid;
                money -= arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int max = 0;
        int sum = 0;
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max;         //금액의 최솟값
        int right = sum;        //금액의 최댓값
        int mid = 0;
        int ans = sum;
        while(left <= right) {      // 이분탐색
            mid = (left + right) / 2;

            if (check(mid) > m) left = mid + 1;     // check는 돈을 인출한 횟수를 return함으로, m보다 큰경우 -> 돈이 부족했던것. -> 돈을 키워주자.
            else {                      // 나머지 경우에는 돈을 인출한 횟수가 m보다 작거나 같은 경우인데, m보다 작을 경우는 m과 같을 경우보다
                right = mid - 1;        // 금액이 클수 밖에 없으므로, 이 경우에서 최소값을 찾으면 당연히 m인출한 경우중 최솟값이 나온다.
                ans = Math.min(ans, mid);
            }
        }
        System.out.println(ans);
    }
}

/**
 *          이분 탐색을 하기 위해서는, 오름차순의 혹은 내림 차순의 배열을 끄집어 낼 수 있어야한다.
 *          위의 문제의 같은 경우에는 눈에 보이는 "날짜별 사용값들"을 정렬할 수 없으므로, 정렬된 배열(이분 탐색할 범위)이 어딘가 숨어 있는 것!!
 *          이 경우에는 "최소금액을 찾아라"라는 문제 조건에서 금액을 그 기준으로 잡아야 한다는 점을 알 수 있다.
 *          금액의 최솟값과 최댓값을 생각해보면.
 *          금액의 최솟값 => n일동안 사용할 금액의 최댓값 (이 금액 보다 작다면 최댓값인 날은 사용이 불가하다)
 *          금액의 최댓값 => n일동안의 사용금액의 총합 (무조건 첫날에는 한번 인출을 해야하는데, 총합을 한번에 인출하면 횟수의 최솟값인 1이다.)
 *
 *
 *
 *   금액의 최솟값                m번 인출의 최솟값(구하려는 값)                                           금액의 최댓값
 *      |                           |                                                                        |
 *      |     모두 불가능한 범위(F)  |                          모두 가능한 범위(T)                            |
 *      |_____________________________________________________________________________________________________|
 *                         |             |               |
 *   <탐색순서>            mid2          mid3            mid1
 *                               (min값으로 등록2)   (min값으로 등록1)
 *
 *
 *    위와 같이 mid4, mid5, mid6....를 구하면서, 가능한 범위안에 있는 mid값들만 min값을 최신화 시키면, 최소 가능한 금액이 나온다.
 */