import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] arr = new int[201];
        int end; 
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            end = x1[i] * x2[i] > 0 ? x2[i]-x1[i] : x2[i]-x1[i]+1;
            for(int j=0;j < end;j++){
                arr[x1[i]+100+j]++;
            }
        }
        int maxVal = 0;
        for(int i=0;i<=200;i++){
            if(arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        System.out.println(maxVal);
    }
}