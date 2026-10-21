import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                int sum = 0;
                for(int l=0;l<3;l++){
                    for(int k=0;k<3;k++){
                        sum += grid[i+l][j+k];
                    }
                }
                maxVal = Math.max(sum, maxVal);

            }
        }
        System.out.println(maxVal);
    }
}