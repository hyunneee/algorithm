import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
		Arrays.sort(arr);

		int start=0;
		int end=arr[n-1];
		while(end>start) {
			
			long cnt=0;
			int mid=(start+end)/2;
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]-mid>0)	{
					cnt+=(arr[i]-mid);
					}
			}
			if(cnt>=m) {
				start=mid+1;
			}
			else
				end=mid;
		}
		System.out.println(start-1);
		
	}

}