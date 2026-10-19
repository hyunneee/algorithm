import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start, end;
        int[] narr = new int[101];
        for (int i = 0; i < n; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            for(int j=start;j<=end;j++){
                narr[j]++;
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<narr.length;i++){
            if(maxVal < narr[i]) maxVal = narr[i];
        }
        System.out.println(maxVal);
        
    }
}