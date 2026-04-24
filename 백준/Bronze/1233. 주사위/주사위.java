import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sum ;
    static int s1,s2,s3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = Integer.parseInt(st.nextToken());
        s2 = Integer.parseInt(st.nextToken());
        s3 = Integer.parseInt(st.nextToken());
        sum = new int[s1+s2+s3+1];
        for(int i=1;i<=s1;i++){
            for(int j=1;j<=s2;j++){
                for(int k=1;k<=s3;k++){
                    sum[i+j+k]++;
                }
            }
        }
        int maxCnt = Integer.MIN_VALUE;
        int maxSum = 0;
        for(int i=1;i<=(s1+s2+s3);i++){
            if(maxCnt < sum[i]){
                maxCnt = sum[i];
                maxSum = i;
            }
        }
        System.out.println(maxSum);
    }
}
