import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MAX_K = 100000;
        int[] arr = new int[2*MAX_K + 1];
        int temp = MAX_K, cur = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            switch(d){
                case 'L':
                cur = temp;
                temp -= (x-1);
                while(x > 0){
                    arr[cur--] = 1;
                    x--;
                }
                break;
                case 'R':
                cur = temp;
                temp += (x-1);
                while(x > 0){
                    arr[cur++] = 2;
                    x--;
                }
                break;
            }
        }
        int white = 0, black = 0;

        for(int i=0;i<2*MAX_K+1;i++){
            if(arr[i] == 1){
                white++;
            } else if(arr[i] == 2){
                black++;
            }
        }
        System.out.println(white+" "+black);
        // Please write your code here.
    }
}