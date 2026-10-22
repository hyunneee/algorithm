import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[n+i] = sc.nextInt();
        }
        for(int sec = 0; sec < t; sec++){
            int tmp = arr[2*n-1]; 
            for(int i=2*n-1;i>0;i--){
                arr[i] = arr[i-1];
            }
            arr[0] = tmp;
        }
        for(int i=0;i<2*n;i++){
            if(i%n==(n-1)){
                System.out.println(arr[i]);
            } else{
                System.out.print(arr[i]+" ");
            }
        }        
    }
}
