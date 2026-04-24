import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] color = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                color[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i=0;i<3;i++){
            dp[0][i] = color[0][i];
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + color[i][j];
            }
        }
        int minCost = Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
        System.out.println(minCost);
    }

}
