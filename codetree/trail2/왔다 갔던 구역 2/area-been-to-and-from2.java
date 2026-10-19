import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 1000;
        int[] narr = new int[2001];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            switch(dir){
                case 'R':
                    for(int j=start;j<start+x;j++){
                        narr[j]++;
                    }
                    start += x;
                    break;
                case 'L':
                    for(int j=start-x;j<start;j++){
                        narr[j]++;
                    }
                    start -= x;
                    break;
                
            }
        }
        int cntLen = 0;
        for(int i=0;i<2001;i++){
            if(narr[i] >= 2) cntLen++;
        }
        System.out.println(cntLen);
    }
}