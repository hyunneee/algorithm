import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사이클 게임 
public class Main {
	static int[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[n];
		for(int i=0;i<n;i++) {
			graph[i] = i;
		}
		int t1, t2;
		int r1,r2;
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			r1 = root(t1); r2 = root(t2);
			if(r1 == r2) {
				System.out.println(i);
				return ;
			}
			else if(r1 < r2 ) {
				// t1에 붙일게요
				graph[r2] = r1;
			} else {
				// t2에 붙일게요
				graph[r1] = r2;
			}
		}
		System.out.println(0);
	}
	
	public static int root(int value) {
		if(graph[value] == value) return value;
		return root(graph[value]);
	}
	
}
