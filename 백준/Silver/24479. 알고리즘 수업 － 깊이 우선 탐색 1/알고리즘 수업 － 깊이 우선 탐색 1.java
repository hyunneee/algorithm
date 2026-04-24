import java.util.ArrayList;
import java.util.Collections;
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
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		ans = new int[N+1];
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<Integer>();
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
		Stack<Integer> stk = new Stack<>();
		stk.add(R);
		while(!stk.isEmpty()) {
			int curr = stk.pop();

			if(visited[curr]) continue;
			visited[curr] = true;
			ans[curr] = count++; // 몇 번째 방문인지 기록
			for (int i=graph[curr].size()-1;i>=0;i--) {
				int next = graph[curr].get(i);
				if (!visited[next]) stk.add(next);
			}
		}
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
