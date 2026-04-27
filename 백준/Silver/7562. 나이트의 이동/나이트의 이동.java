import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int I;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=0;tc<T;tc++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] curr = new int[]{A, B};
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int[] target = new int[]{A, B};

            System.out.println(bfs(curr, target));
        }
    }
    public static class Node implements Comparable<Node> {
        int i,j,val;
        public Node(int i,int j,int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int compareTo(Node o){
            return this.val - o.val;
        }

    }
    public static int bfs(int[] curr, int[] target){
        int[] dr = {-2,-2,-1,-1,1,1,2,2};
        int[] dc = {-1,1,-2,2,-2,2,-1,1};
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(curr[0],curr[1],0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(tmp.i == target[0] && tmp.j == target[1]){
                return tmp.val;
            }
            for(int i=0;i<8;i++){
                int tr = tmp.i + dr[i];
                int tc = tmp.j + dc[i];
                if(tr < 0 || tr >= I || tc < 0 || tc >= I || visited[tr][tc]) continue;
                visited[tr][tc] = true;
                pq.add(new Node(tr,tc,tmp.val+1));
            }
        }
        return 0;
    }
}
