import java.util.Scanner;
public class Main {
    static int n = 0,m = 0, answer = 0;;
    static int[][] grid;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        visited[0][0] = true;
        
        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int i,int j){
        if(i == n-1 && j == m-1){
            answer = 1;
            return ;
        }
        if(grid[i][j] == 0) {
            
            return ;
        }
        for(int d=0;d<4;d++){
            int tr = i + dir[d][0];
            int tc = j + dir[d][1];
            if(tr < 0 || tr >= n || tc < 0 || tc >= m) continue;
            if(visited[tr][tc]) continue;
            visited[tr][tc] = true;
            dfs(tr,tc);
        }
    }
}