import java.util.Scanner;

public class Main {
    public static int k, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        for(int i=1;i<=k;i++){
            choose(i,0,new int[n]);
        }
        
    }

    // 1

    public static void choose(int tk, int tn, int[] arr){
        arr[tn] = tk;
        
        if(tn == n-1){
            // print 
            StringBuilder sb = new StringBuilder("");
            int prev = arr[0];
            int cnt = 0;
            for(int i=0;i<n;i++){
                if(cnt == 3) return ;
                if(prev == arr[i]){
                    cnt++;
                } else if(cnt >= 3){
                    return ;
                } else{
                    cnt = 1;
                    prev = arr[i];
                }
                sb.append(arr[i]).append(" ");
            }
            if(cnt == 3) return ; 
            System.out.println(sb.toString());
            return ;
        } // 종료 조건 도달함 
        
        
        for(int j = 1; j <= k; j++){
            choose(j,tn+1, arr);
        }

    }
}