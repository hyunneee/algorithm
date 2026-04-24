import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] divSum = new int[N+1];
        for(int i=1;i<=N;i++){
            divSum[i] = i;
            int temp = i;
            while(temp > 0){
                divSum[i] += (temp%10);
                temp /= 10;
            }
        }
        int result = 0;
        for(int i=1;i<N;i++){
            if(divSum[i] == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
