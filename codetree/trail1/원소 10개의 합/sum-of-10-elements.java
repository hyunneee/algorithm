import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=0;i<10;i++){
            int v = sc.nextInt();
            sum += v;
        }
        System.out.print(sum);
    }
}