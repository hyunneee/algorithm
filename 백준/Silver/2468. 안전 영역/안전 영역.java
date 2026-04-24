import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0,-1,  0};
    static int N;
    static int maxCnt = 1;
    static int maxVol = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<str.length;j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] > maxVol) maxVol = map[i][j];
            }
        }
        for(int k=0; k<maxVol;k++){
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] > k&& !visited[i][j] ){
                        dfs(i,j,k);
                        cnt++;
                    }
                }
            }
            if(cnt > maxCnt) maxCnt = cnt;
        }
        System.out.println(maxCnt);
    }

    public static void dfs(int i, int j, int k){
        visited[i][j] = true;
        for(int l=0;l<4;l++){
            int tr = i + dr[l];
            int tc = j + dc[l];
            if(0<= tr && tr <N && 0<=tc&& tc<N){
                if(map[tr][tc] > k && !visited[tr][tc]){
                    dfs(tr,tc,k);
                }
            }
        }
    }
}
