import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];
        int[] black = new int[200001];
        int[] white = new int[200001];
        int[] result = new int[200001]; // 1: black 2:white 3:gray 
        int blackCnt = 0, whiteCnt = 0, grayCnt = 0;
        int start = 100000;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
            if(dir[i] == 'R'){
                for(int j=start;j<start+x[i];j++){
                    black[j]++;
                    result[j] = (black[j] >= 2 && white[j] >= 2) ? 3 :1;
                }
                start += (x[i] - 1);
            } else if(dir[i] == 'L'){
                for(int j=start;j>start-x[i];j--){
                    white[j]++;
                    result[j] = (black[j] >= 2 && white[j] >= 2) ? 3 : 2;
                }
                start -= (x[i] - 1);
            }
        }
        for(int i=0;i<=200000;i++){
            if(black[i] >= 2 && white[i] >= 2){
                grayCnt++;
            } else if(result[i] == 1){
                blackCnt++;
           } else if(result[i] == 2){
                whiteCnt++;
            }
        }
        System.out.println(whiteCnt+" "+blackCnt+" "+grayCnt);
    }
}