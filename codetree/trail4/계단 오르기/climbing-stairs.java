import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0; // 불가능한 경우 

        answer = step(n);
        System.out.println(answer);
    }

    public static int step(int n){
        if(n < 3){
            return 1;
        }
        int[] memo = new int[n+1];
        memo[2] = 1;
        memo[3] = 1;
        for(int i=4;i<=n;i++){
            
            memo[i] = (memo[i-2]+memo[i-3])%10007;
        }
        return memo[n];
    }
}