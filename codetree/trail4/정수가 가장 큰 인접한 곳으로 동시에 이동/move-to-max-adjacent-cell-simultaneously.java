import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt() - 1;
            marbles[i][1] = sc.nextInt() - 1;
        }
        for(int sec = 0;sec<t;sec++){
            marbles = getMarbles(grid, marbles, n);
        }
        System.out.println(marbles.length);
    }

    public static int[][] getMarbles(int[][] grid, int[][] marbles, int n){
        int[][] cArr = new int[n][n];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] newMarbles = new int[marbles.length][2];
        for(int i=0;i<marbles.length;i++){
            int r = marbles[i][0];
            int c = marbles[i][1];
            int maxVal = -1, tmpIdx = 0;
            boolean canMove = false;
            for(int d=0;d<4;d++){
                int tr = r + dir[d][0];
                int tc = c + dir[d][1];
                if(!inRange(tr,tc,n)) continue;
                if(grid[tr][tc] > maxVal){
                    maxVal = grid[tr][tc];
                    tmpIdx = d;
                    canMove = true;
                }
            }
            if(canMove) cArr[r + dir[tmpIdx][0]][c + dir[tmpIdx][1]]++;
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cArr[i][j] == 1){
                    newMarbles[cnt][0] = i;
                    newMarbles[cnt][1] = j;
                    cnt++;
                }
            }
        }
        return Arrays.copyOf(newMarbles, cnt);
    }

    public static boolean inRange(int r, int c, int n){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}