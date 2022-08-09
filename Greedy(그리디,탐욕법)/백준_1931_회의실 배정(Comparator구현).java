import java.io.*;
import java.util.*;


class Pair{
    Integer start;
    Integer end;

    public Pair(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Pair[] arr = new Pair[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Pair p = new Pair(s, e);
            arr[i] = p;
        }

        Arrays.sort(arr, new Comparator<Pair>(){
           @Override
            public int compare(Pair p1, Pair p2){
               return (p1.end == p2.end) ? p1.start.compareTo(p2.start) : p1.end.compareTo(p2.end);
            }
        });
        int cnt = 1;
        int norm = arr[0].end;
        for(int i = 1 ;i < n; i++){
            if(arr[i].start >= norm){
                cnt++;
                norm = arr[i].end;
            }
        }
        System.out.println(cnt);


    }
}

