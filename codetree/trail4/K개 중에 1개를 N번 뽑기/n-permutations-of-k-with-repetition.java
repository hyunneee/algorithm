import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        for(int i=1;i<=k;i++){
            choose(k,n,i,1,new int[n+1]);
        }
    }
    // 1 x x x
    // 1 1 1 1
    public static void choose(int k, int n, int tk, int tn, int[] arr){

        arr[tn] = tk;
         if(tn >= n){
            for(int i=1;i<=n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return ;
        }
       for(int j=1;j<=k;j++){
            choose(k,n,j,tn+1,arr);
        }
    }
}