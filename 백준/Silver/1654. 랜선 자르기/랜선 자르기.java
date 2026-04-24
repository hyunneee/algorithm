import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
		Arrays.sort(arr);
		
		long start=1;
		long end=arr[k-1];
		long mid=0;
		while(end>=start) {
			mid=(start+end)/2;
			long cnt=0;
			for(int i=0;i<arr.length;i++) {
					cnt+=arr[i]/mid;
					//System.out.println(cnt);
			}
			if(cnt>=n) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		System.out.println(end);
		
	}

}