import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int tc = 1;
        while(N!=0){
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int val = bfs(0,0);
            System.out.println("Problem "+(tc++)+": "+val);
            N = Integer.parseInt(br.readLine());
        }
    }

    static public class Node implements Comparable<Node> {
        int i,j,val;
        public Node(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static int bfs(int i,int j){
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(map[i][j],i,j));
        visited[i][j] = true;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.i == N-1 && curr.j == N-1) return curr.val;
            for(int d=0;d<4;d++){
                int tr = curr.i + dr[d];
                int tc = curr.j + dc[d];
                if(tr < 0 || tr >= N || tc < 0 || tc >= N || visited[tr][tc]) continue;
                int tw = curr.val + map[tr][tc];
                visited[tr][tc] = true;
                q.add(new Node(tw,tr,tc));
            }
        }
        return 0;
    }
}
