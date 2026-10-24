import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] a;
    public static boolean[][] visited;
    public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int n,m, answer = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        
        bfs(0,0,0);
        System.out.println(answer);
    }

    public static void bfs(int i, int j, int step){
       Queue<int[]> q = new ArrayDeque<>();
       int[] temp = new int[3];
       q.add(new int[]{i,j,0});
       visited[i][j] = true;
       
       while(!q.isEmpty()){
            temp = q.poll();
            for(int d=0;d<4;d++){
                int tr = temp[0] + dir[d][0];
                int tc = temp[1] + dir[d][1];
                if(tr < 0 || tr >= n || tc < 0 || tc >= m) continue;
                if(visited[tr][tc]) continue;
                if(a[tr][tc] == 0) continue;

                if(tr == n-1 && tc == m-1){
                    answer = temp[2] + 1;
                    return ;
                }
                visited[tr][tc] = true;
                q.add(new int[]{tr,tc,temp[2]+1});
            }
       }
    }
}