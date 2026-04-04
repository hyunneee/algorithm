import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = 0;
        int N = sc.nextInt();
        long s_x = sc.nextInt();
        long s_y = sc.nextInt();
        long e_x = sc.nextInt();
        long e_y = sc.nextInt();
        long minDist = Long.MAX_VALUE;
        int minIdx = 0;
        for(int i=1;i<=N;i++){
            M = sc.nextInt();
            long tx = s_x;
            long ty = s_y;
            long dist = 0;
            for(int j=0;j<M;j++){
                long x = sc.nextInt();
                long y = sc.nextInt();
                dist += (Math.abs(tx-x) + Math.abs(ty-y));
                tx = x; ty = y;
            }
            dist += (Math.abs(tx-e_x) + Math.abs(ty-e_y));
            if(dist < minDist){
                minDist = dist;
                minIdx = i;
            }
        }
        System.out.println(minIdx);


    }
}
