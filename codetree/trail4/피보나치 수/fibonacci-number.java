import java.util.Scanner;
public class Main {
    public static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int answer = fibo(n);
        System.out.println(answer);
    }

    public static int fibo(int n){
        if(n==1) return 1;
        if(n==2) return 1;
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 1;
        for(int i=3;i<=n;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}