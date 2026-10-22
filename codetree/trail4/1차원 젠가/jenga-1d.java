import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        // int len = n;
        // int ti = 0;
        // for(int i=e1;i<len;i++){
        //     blocks[s1+ti] = blocks[i];
        //     ti++;
        // }
        // len -= (e1-s1+1);
        // ti = 1;
        // for(int i=e2;i<len;i++){
        //     blocks[s2+ti] = blocks[i];
        //     ti++;
        // }
        // len -= (e2-s2+1);
        blocks = getTemp(s1,e1,n, blocks);
        blocks = getTemp(s2,e2,blocks.length,blocks);
        System.out.println(blocks.length);
        for(int i=0;i<blocks.length;i++){
            System.out.println(blocks[i]);
        }
    }

    public static int[] getTemp(int s, int e,int n, int[] blocks){

        // temp arr에 저장하기 
        int[] tmp = new int[n];
        int k = 0;
        for(int i=0;i<n;i++){
            if(i >= (s-1) && i < e){
                continue;
            }
            tmp[k++] = blocks[i];
        }

        return Arrays.copyOf(tmp, k);
    }
}