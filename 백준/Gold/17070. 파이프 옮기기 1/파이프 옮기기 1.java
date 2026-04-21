import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {0,1,1}; // 가로, 세로, 대각선 
	static int[] dc = {1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			map[0][i] = 1;
			map[i][0] = 1;
			map[N][i] = 1;
			map[i][N] = 1;
		}
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N+1][N+1][3];
		dp[1][2][0] = 1;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j] == 1) continue;
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			
			}
		}		
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
		
	}
}
