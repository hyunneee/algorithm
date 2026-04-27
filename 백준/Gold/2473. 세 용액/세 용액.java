import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] val = new long[N];
        for(int i=0;i<N;i++){
            val[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(val);

        long curMin = Long.MAX_VALUE;

        // 투 포인터
        long[] result = new long[3];
        for(int i=0;i<N-2;i++){ // 고정 인덱스
            int left = i+1;
            int right = N-1;

            while(left < right){
                long sum = val[i] + val[left] + val[right];

                if(Math.abs(sum) < curMin){
                    curMin = Math.abs(sum);
                    result[0] = val[i];
                    result[1] = val[left];
                    result[2] = val[right];
                }

                if(sum > 0) right--;
                else if(sum < 0) left++;
                else break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(long v : result){
            sb.append(v).append(" ");
        }
        System.out.println(sb.toString());
    }
}
