import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] relation;
    static int res=-1;
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i=1;i<=n;i++){
            relation[i]= new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
       
        int m = Integer.parseInt(br.readLine());
       
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int c3 = Integer.parseInt(st.nextToken());
            int c4 = Integer.parseInt(st.nextToken());
            relation[c3].add(c4);
            relation[c4].add(c3);
          
        }
        dfs(c1,c2,0);
        
        System.out.println(res);
		
            
    }      

    static void dfs(int start,int target,int cnt) {
        if(start == target){
            res = cnt;
            return;
        }
        // 방문 처리
        visited[start] = true;
        // 방문한 노드에 인접한 노드 찾기
        
        for (int i=0;i<relation[start].size();i++){
            int node = relation[start].get(i);
            if(!visited[node]) {
               dfs(node,target,cnt+1);
            }
        }    
    }     
}