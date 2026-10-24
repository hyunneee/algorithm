import java.util.Scanner;
import java.util.*;

public class Main {
    static int val;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        int u,v;
        for (int i = 0; i < m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited[1] = true;
        dfs(1);
        System.out.println(val);

    }

    public static void dfs(int t){
        for(int i=0;i<graph[t].size();i++){
            int temp = graph[t].get(i);
            if(visited[temp]) continue;
            val++;
            visited[temp] = true;
            dfs(temp);
            
        }
    }
}