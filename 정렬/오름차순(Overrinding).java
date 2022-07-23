import java.util.*;

/**
 *  객체의 정렬 기준을 정의하는 방법으로 정렬 대상 클래스를 자바에서 기본적으로 제공하고 있는 Comparable 인터페이스를 구현함.
 *  이 인터페이스 안에 있는 compareTo() 메서드를 통해 인자로 넘어온 같은 타입의 객체를 비교가능.
 */

class Pair implements Comparable<Pair>{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o){
        return x - o.x;
        // 매개변수 객체의 x와 비교해서 넘어온 객체의 x보다 작을 경우 -양수
        // 클 경우 - 음수
        // 같을 경우 - 0을 반환.
    }
}

public class Main{
    public static void main(String[] args) {
        Pair p1 = new Pair(4, 9);
        Pair p2 = new Pair(2, 10);
        Pair p3 = new Pair(7, 3);
        Pair[] arr = {p1, p2, p3};

        Arrays.sort(arr);       // x를 기준으로 오름차순 정렬

        for(Pair p : arr) System.out.println(p.x + " " + p.y);
    }
}