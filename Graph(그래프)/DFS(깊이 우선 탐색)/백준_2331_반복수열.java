import java.util.*;

class Main {
  static int[] count_arr = new int[300000];

  static void DFS(int a, int p){
    double new_a = 0;
    while( a> 0){
      double left = a %10;
      new_a += Math.pow(left, p);
      a /=10;
    }

    int x = (int) new_a;
    count_arr[x]++;
    if(count_arr[x] > 2) return;
    DFS(x,p);
  
  }
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int A = s.nextInt(); 
    int P = s.nextInt();

    count_arr[A]++;
    DFS(A, P);
    int count = 0;
    for(int i =0 ; i< count_arr.length; i++)
      if(count_arr[i] == 1) count++;

    System.out.println(count);
    

    
  }
}