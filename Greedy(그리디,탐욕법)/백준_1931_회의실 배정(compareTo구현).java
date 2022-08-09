import java.io.*;
import java.util.*;


class Pair implements Comparable<Pair>{
    Integer start;
    Integer end;

    public Pair(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return (this.end == o.end) ? this.start.compareTo(o.start) : this.end.compareTo(o.end);
//       if(this.end == o.end){
//           if(this.start > o.start) return 1;
//           else return -1;
//       }
//       else if(this.end > o.end) return 1;
//       else return -1;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Pair> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Pair p = new Pair(s, e);
            list.add(p);
        }

        Collections.sort(list);

        int norm = list.get(0).end;
        int cnt = 1;

        for(int i = 1; i< list.size(); i++){
            if(list.get(i).start >= norm){
                norm = list.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}

