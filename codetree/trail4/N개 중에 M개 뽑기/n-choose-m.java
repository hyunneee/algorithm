import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[] arr, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        choose(0);
    }

    public static void choose(int dep){
        if(dep == m){
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return ;
        }
        int start = (dep == 0) ? 1 : arr[dep-1] + 1;

        for(int j = start; j <= n;j++){
            arr[dep] = j;
            choose(dep+1);
        }
    }
}