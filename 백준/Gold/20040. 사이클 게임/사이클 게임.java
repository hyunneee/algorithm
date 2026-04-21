import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사이클 게임 
public class Main {
	static class Node{
		Node parent;
		int value;
		
		Node(int v){
			this.value = v;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] graph = new Node[n];
		for(int i=0;i<n;i++) {
			graph[i] = new Node(i);
		} // 최대 백만번

		int t1, t2;
		Node r1,r2;
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			r1 = root(graph[t1]); r2 = root(graph[t2]);
			if(r1 == r2) {
				System.out.println(i);
				return ;
			}
			else if(r1.value < r2.value) {
				// t1에 붙일게요
				r2.parent = r1;
			} else {
				// t2에 붙일게요
				r1.parent = r2;
			}
		}
		System.out.println(0);
	}
	
	public static Node root(Node node) {
		if(node.parent == null) return node;
		return root(node.parent);
	}
	
}
