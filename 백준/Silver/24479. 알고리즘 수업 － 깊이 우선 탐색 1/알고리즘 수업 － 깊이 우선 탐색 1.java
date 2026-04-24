import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	static boolean[] visited;
	static List<Integer>[] graph;
	static int[] ans; 
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		graph = new LinkedList[N+1];
		visited = new boolean[N+1];
		ans = new int[N+1];
		for(int i=1;i<=N;i++) {
			graph[i] = new LinkedList<Integer>();
		}

		for(int i=0;i<M;i++) {
			int val1 = sc.nextInt();
			int val2 = sc.nextInt();
			graph[val1].add(val2);
			graph[val2].add(val1);
		}
		
		for (int i = 1; i <= N; i++) {
		    Collections.sort(graph[i]);
		}
		
		count = 1;
		dfs(R);
		for(int i=1;i<=N;i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static void dfs(int r) {
		visited[r] = true;
	    ans[r] = count++; // 몇 번째 방문인지 기록
	    for (int next : graph[r]) {
	        if (!visited[next]) dfs(next);
	    }
	}
}
