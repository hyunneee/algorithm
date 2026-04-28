import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int i,int j) {
		int[] dr = {-1,-1,-1,0,1,1,1,0};
		int[] dc = {-1,0,1,1,1,0,-1,-1};
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<8;d++) {
				int tr = curr[0] + dr[d];
				int tc = curr[1] + dc[d];
				if(tr < 0 || tr >= h || tc < 0 || tc >= w || visited[tr][tc] || map[tr][tc] == 0) continue;
				visited[tr][tc] = true;
				q.add(new int[] {tr,tc});
			}
		}
	}
}
