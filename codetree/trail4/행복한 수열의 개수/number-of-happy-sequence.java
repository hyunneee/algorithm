import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int maxCnt = 0;
        for(int i=0;i<n;i++){
            int cnt = 1;
            int prev = grid[i][0];
            for(int j=1;j<n;j++){
                if(cnt >= m) break;
                if(prev == grid[i][j]){
                    cnt++;
                } else{
                    prev = grid[i][j];
                    cnt = 1;
                }
            }
            if(cnt >= m) maxCnt++;
            
            cnt = 1;
            prev = grid[0][i];
            for(int j=1;j<n;j++){
                if(cnt >= m) break;
                if(prev == grid[j][i]){
                    cnt++;
                } else{
                    prev = grid[j][i];
                    cnt = 1;
                }
            }
            if(cnt >= m) maxCnt++;
            
        }
        System.out.println(maxCnt);
    }
}