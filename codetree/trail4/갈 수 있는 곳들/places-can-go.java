import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class Main {
    public static int[][] grid;
    public static boolean[][] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        grid = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        int ans = 0;
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1;
            starts[i][1] = sc.nextInt() - 1;
            if(!vis[starts[i][0]][starts[i][1]]) ans += bfs(starts[i]);
        }
        System.out.println(ans);
    }

    public static int bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int n = grid.length;
        q.add(start);
        vis[start[0]][start[1]] = true;
        int answer = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int d=0;d<4;d++){
                int tr = temp[0] + dir[d][0];
                int tc = temp[1] + dir[d][1];
                if(tr < 0 || tr >= n || tc < 0 || tc >= n){
                    continue;
                }
                if(vis[tr][tc] || grid[tr][tc] == 1) continue;
                vis[tr][tc] = true;
                q.add(new int[]{tr,tc});
                answer++;
            }
        }
        return answer;
    }
}