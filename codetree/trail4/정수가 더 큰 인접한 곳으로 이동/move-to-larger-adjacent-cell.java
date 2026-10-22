import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] isVisited = new boolean[n+1][n+1];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int tmp;
        boolean canMove;
        while(true){
            tmp = grid[r][c];
            System.out.print(tmp+" ");
            isVisited[r][c] = true;
            canMove = false;
            for(int d=0;d<4;d++){
                int tr = r + dir[d][0];
                int tc = c + dir[d][1];
                if(!inRange(tr,tc,n)) continue;
                if(grid[tr][tc] > tmp){
                    r = tr;
                    c = tc;
                    canMove = true;
                    break;
                }
            }
            if(!canMove) break;
        }
    }

    public static boolean inRange(int r, int c, int n){
        if(r <= 0 || r > n || c <= 0 || c > n){
            return false;
        }
        return true;
    }
}