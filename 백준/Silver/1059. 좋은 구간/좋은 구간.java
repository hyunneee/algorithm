import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s= Integer.parseInt(br.readLine());
		int[] arr = new int[s];
		String slen[] = br.readLine().split(" ");
		
		for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(slen[i]);
        }
		Arrays.sort(arr);
		
		/*
		for (int i=0;i<s;i++) {
			System.out.println(arr[i]);
		}
		*/
		int n = Integer.parseInt(br.readLine());
		int before=0, after=0;
		for(int i=0;i<s;i++) {
			if(arr[i]==n) {
				System.out.println("0");
				System.exit(0);
			}
			else if(arr[i]<n) {
				before = arr[i];
			}
			else if(arr[i]>n) {
				after = arr[i];
				break;
			}
		}
		System.out.println((n-before-1)*(after-n)+after-n-1);
		
		
	}

}
