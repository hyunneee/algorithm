
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] roadl = new long[n-1];
		long[] city = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n-1;i++) {
			roadl[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			city[i] = Long.parseLong(st.nextToken());
		}
		long tmp = city[0];
		long sum = city[0]*roadl[0];
		for(int i=1;i<n-1;i++) {
			if(tmp > city[i]) {
				tmp = city[i];
			}
			else {
				city[i] = tmp;
			}
//			System.out.println(tmp);
//			System.out.println("city["+i+"]="+city[i]);
//			System.out.println("road["+i+"]="+roadl[i]);
			sum+=(roadl[i]*city[i]);
		}
		System.out.println(sum);
		
		
	}
}