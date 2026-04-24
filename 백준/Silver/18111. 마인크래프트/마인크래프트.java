
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n][m];
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;	
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			
				max=Math.max(max, arr[i][j]);
				min=Math.min(min, arr[i][j]);
				
			}
		}
		 
		int ans_seconds=Integer.MAX_VALUE;
		int ans_h=0;
		
		for(int i=min;i<=max;i++) {
			int seconds=0;
			int block=b;
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(arr[j][k]>i) { // 더 높으니까 없애줌
					seconds+=(arr[j][k]-i)*2;
					block+=(arr[j][k]-i);
					}
					else if(arr[j][k]<i) { //더 낮으므로 추가해주기 
					seconds+=(i-arr[j][k]);
					block-=(i-arr[j][k]);
					}
				}
			}
			if(block>=0) { //인벤토리가 음수가 나온다는 건 블록수 부족한 거니
				if(seconds<=ans_seconds) {
					ans_seconds=seconds;
					ans_h=i;
				}}
			}
		System.out.println(ans_seconds+" "+ans_h);
		System.exit(0);
	}
}