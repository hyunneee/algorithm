import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int maxDist, N,K;
	static int[] dr = {-1,1,0,0}; // 상, 하, 좌, 우
	static int[] dc = {0,0,-1,1}; 
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			int maxVal = 0;
			maxDist = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(maxVal < map[i][j]) maxVal = map[i][j];
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visited = new boolean[N][N];
					if(map[i][j] == maxVal) {
						backtracking(i,j,maxVal,1,false);
					}
				}
			}
			System.out.println("#"+tc+" "+maxDist);
		}
		
	}
	
	public static void backtracking(int i, int j, int h, int cnt,boolean isUsedK) {
		maxDist = Math.max(maxDist, cnt);
		visited[i][j] = true;
		for(int d=0;d<4;d++) {
			int tr = i + dr[d];
			int tc = j + dc[d];
			if(tr < 0 || tr >= N || tc < 0 || tc >= N || visited[tr][tc] ) continue;
			if(map[tr][tc] < h) {
				backtracking(tr,tc,map[tr][tc],cnt+1,isUsedK);
			} else if(!isUsedK && map[tr][tc] - K < h){
				backtracking(tr,tc,h-1,cnt+1,true);
				visited[tr][tc] = false;
			}
		}
		visited[i][j] = false;
	}
}
