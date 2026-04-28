import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][1001];
		for(int tc=1;tc<=T;tc++) {
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] alist = st.nextToken().toCharArray();
			char[] blist = st.nextToken().toCharArray();
			dp = new int[alist.length+1][blist.length+1];

			for(int i=1;i<=alist.length;i++) {
				for(int j=1;j<=blist.length;j++) {
					if(alist[i-1] == blist[j-1]) {
						dp[i][j] = dp[i-1][j-1] + 1; 
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			System.out.println("#"+tc+" "+dp[alist.length][blist.length]);
		}
	}
}
