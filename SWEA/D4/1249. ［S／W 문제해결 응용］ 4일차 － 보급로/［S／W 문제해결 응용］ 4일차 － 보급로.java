import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	public static int N;
	public static int[][] map, weight;
	public static int[][] fixedTime;
	public static int[] spos = new int[] {0,0};
	public static int[] epos = new int[2];
	public static int[] dr = {-1,1,0,0}; // 상하좌우
	public static int[] dc = {0,0,-1,1};
	public static boolean[][] visited;
	
	public static class Node implements Comparable<Node>{
		int r,c,time;
		
		Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time; // 시간 오름차순 
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // testcase
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			weight = new int[N][N];
			fixedTime = new int[N][N];
			visited = new boolean[N][N];
			epos = new int[] {N-1,N-1};
			for(int i=0;i<N;i++) {
				String st = br.readLine();
				for(int j=0;j<st.length();j++) {
					map[i][j] = st.charAt(j) - '0'; // 보수가 필요한 시간 
					weight[i][j] = Integer.MAX_VALUE; // 최소 시간을 저장할 공간 
//					System.out.print(map[i][j]+" ");
				}
//				System.out.println();
			}
			Node spos = new Node(0,0,map[0][0]);
			getFixedTime(spos);
			System.out.println("#"+tc+" "+weight[N-1][N-1]);
		}
		
	}
	
	public static void getFixedTime(Node spos) {
		PriorityQueue<Node> pqs = new PriorityQueue<>();
		pqs.add(spos); // 시작 노드 
		weight[0][0] = 0;
		
		while(!pqs.isEmpty()) {
			Node pos = pqs.poll();
			if(pos.time > weight[pos.r][pos.c]) continue;  
			for(int i=0;i<4;i++) {
				int tr = pos.r + dr[i];
				int tc = pos.c + dc[i];
				if(tr < 0 || tr >= N || tc < 0 || tc>=N) continue;
				// 인접한 애들 넣기 
				if(map[tr][tc] + weight[pos.r][pos.c] < weight[tr][tc]) {
					weight[tr][tc] = map[tr][tc] + weight[pos.r][pos.c];
					pqs.add(new Node(tr,tc,weight[tr][tc]));
				}
			}
		}
	}
}
