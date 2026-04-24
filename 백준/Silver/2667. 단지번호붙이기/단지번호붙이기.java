import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 1, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited= new boolean[N][N];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = line.charAt(j) - 48;
			}
		}
		int value = 0;
		int[] ans = new int[N*N];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]== 1 && !visited[i][j]) {
					cnt = 1;
					 dfs(i,j);
					 ans[value] = cnt;
					 ++value;
				}
			}
		}
		
		System.out.println(value);
		Arrays.sort(ans, 0, value);
		for(int i=0;i<value;i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static void dfs(int i, int j) {
		if(visited[i][j]) return ;
		if(map[i][j] == 0) return ;
		int[] dr = { 0, 0, -1, 1}; // 좌우상하
		int[] dc = {-1, 1,  0, 0};
		visited[i][j] = true;
		for(int k=0;k<4;k++) {
			int tr = i + dr[k];
			int tc = j + dc[k];
			if(tr < 0 || tr >= N || tc < 0 || tc >= N) {
				continue;
			}
			if(map[tr][tc] == 1 && !visited[tr][tc]) {
				cnt++;
//				System.out.println("cnt++"+cnt);
				dfs(tr,tc);
			}
		}
	}
}
