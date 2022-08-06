import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Character>[] tree;  //  = new ArrayList[n]; -> n이 대입되지 않은 채로 생성됨.
    // 여기서 new 키워드를 이용해, 동적배열을 생성시, static 변수들이 먼저 메모리에 올라가기 때문에 배열의 길이가 올라기지 않음
    static final int left = 1;
    static final int right = 2;
    static void preorder_DFS(char c){       // 전위 순회
        if(c == '.') return;

        System.out.print(c);
        preorder_DFS(tree[c-65].get(left));
        preorder_DFS(tree[c-65].get(right));
    }
    static void inorder_DFS(char c){        // 중위 순회
        if(c == '.') return;

        inorder_DFS(tree[c-65].get(left));
        System.out.print(c);
        inorder_DFS(tree[c-65].get(right));
    }
    static void postorder_DFS(char c){      //후위 순회
        if(c == '.') return;

        postorder_DFS(tree[c-65].get(left));
        postorder_DFS(tree[c-65].get(right));
        System.out.print(c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n];
        for(int i = 0; i< n; i++) tree[i] = new ArrayList<>();      // 이차원 동적배열 생성.
        // 먼저 배열을 선언하고, 알파벳 순으로 배열을 정렬하기 위해.

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int index = 0;
            for(int j = 0; j < 3; j++){
                Character c = (st.nextToken()).charAt(0);
                if(j == 0) index = c-65;        // 각 동적배열의 첫 알파벳 들어오는 순서대로 배열을 정렬.
                tree[index].add(c);
                /**
                 * A B C
                 * B D .
                 * C E F
                 * D . .
                 * E . .
                 * F . G
                 * G . .
                 * 
                 * 로 정렬
                 */
            }
        }

        preorder_DFS('A');
        System.out.println();
        inorder_DFS('A');
        System.out.println();
        postorder_DFS('A');
    }
}

