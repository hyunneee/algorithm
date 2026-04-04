import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            String s = st.nextToken();
            map[i] = Integer.parseInt(s);
        }
        int[] counts = new int[1000001];
        boolean isHang = false;
        int target = (int) Math.ceil(9*M/10.0);

        for(int i=0;i<M;i++) {
            counts[map[i]]++;
            if(counts[map[i]] >= target) isHang = true;
        }

        for(int i=M;i<N;i++){
            if(isHang) break;
            counts[map[i-M]]--;
            counts[map[i]]++;
            if(counts[map[i]] >= target) isHang = true;
        }
        if(isHang){
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
