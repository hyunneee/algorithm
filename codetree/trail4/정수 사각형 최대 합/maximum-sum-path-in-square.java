import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n+1][n+1];
        int r = 1, c = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
            // 아래로 내려가면서 조회하기 
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}