import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr,Collections.reverseOrder());
		for(int i=0;i<n/3;i++) {
			sum-=arr[3*i+2];
			
		}
		System.out.println(sum);
	}
}
