import java.io.*;
import java.util.*;

class Person{
    int num;
    int withdraw_time;
    public Person(int num, int withdraw_time){
        this.num = num;
        this.withdraw_time = withdraw_time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int t = Integer.parseInt(st.nextToken());

            Person p = new Person(i, t);
            list.add(p);
        }
        
        // 인출 시간에 따라 오름차순으로 정렬
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                return p1.withdraw_time - p2.withdraw_time;
            }
        });
        
        // 누적합 구하기
        int[] ans = new int[n];
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).withdraw_time;
            if(i == 0) ans[i] = x;
            else ans[i] = ans[i-1] + x;
        }

        int sum = 0;
        for(int i : ans) sum += i;
        System.out.println(sum);


    }
}
