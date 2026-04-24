import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int t = Integer.parseInt(br.readLine());
		for(int k=0;k<t;k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] narr = new int[n];
			int[] marr = new int[m];
			
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
	            narr[i] = Integer.parseInt(st.nextToken());
	        }
			Arrays.sort(narr);

			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
	            marr[i] = Integer.parseInt(st.nextToken());
	        }
			Arrays.sort(marr);
			int cnt=0;
			for(int i=n-1;i>=0;i--) {
				for(int j=m-1;j>=0;j--) {
					if(narr[i]>marr[j]) {
						cnt+=(j+1);
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
