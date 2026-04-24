import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int w = 0, h=0, cnt=0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1,  0,  1, 1, 1, 0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] wh = br.readLine().split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);
            cnt = 0;
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int i, int j){
        int tr = 0, tc = 0;
        visited[i][j] = true;
        for(int k=0;k<8;k++){
            tr = i+dr[k];
            tc = j+dc[k];
            if(0<=tr && tr <h && 0<=tc&& tc<w){
                if(map[tr][tc] == 1 && !visited[tr][tc]) dfs(tr,tc);
            }
        }
    }
}
