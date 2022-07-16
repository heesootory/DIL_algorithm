import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int _case = 1;
        while(t-- > 0){
            int n = s.nextInt();
            int m = n/10;
            int k = s.nextInt();
            Double[] score = new Double[n];     //내림차순을 사용하기 위해 객체형 Double를 사용.
            double _score = 0;
            for(int i = 0; i<n; i++){
                int a = s.nextInt();
                int b = s.nextInt();
                int c = s.nextInt();
                score[i] = (double)((a * 35) + (b * 45) + (c * 20)) / 100;
                if(i == k-1) _score = score[i];
            }
            Arrays.sort(score, Collections.reverseOrder());     //내림차순
            int rank = 0;
            for(int i = 0; i< score.length; i++){
                if(score[i] == _score) {
                    rank = i+m; break;      //1등부터도 계산해야 함으로, +1
                }
            }
            System.out.print("#"+_case+" ");
            switch (rank / m) {
                case 1:
                    System.out.println("A+");
                    break;
                case 2:
                    System.out.println("A0");
                    break;
                case 3:
                    System.out.println("A-");
                    break;
                case 4:
                    System.out.println("B+");
                    break;
                case 5:
                    System.out.println("B0");
                    break;
                case 6:
                    System.out.println("B-");
                    break;
                case 7:
                    System.out.println("C+");
                    break;
                case 8:
                    System.out.println("C0");
                    break;
                case 9:
                    System.out.println("C-");
                    break;
                case 10:
                    System.out.println("D0");
                    break;
            }
            _case++;
        }
    }
}