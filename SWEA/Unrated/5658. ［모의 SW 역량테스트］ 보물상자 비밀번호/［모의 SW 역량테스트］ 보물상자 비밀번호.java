import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String code = br.readLine();
			int rotate = N/4;
			code = code.concat(code);
//			System.out.println("code"+ code);
			TreeSet<String> strset = new TreeSet<>(Collections.reverseOrder());
			for(int r=0;r<rotate;r++) {
				for(int k=0;k<4;k++) {
					strset.add(code.substring(rotate*k+r, rotate*(k+1)+r));
				}
			}
			List<String> resultList = new ArrayList<>(strset);
			String str = resultList.get(K-1);
			int value = Integer.parseInt(str,16);
			System.out.println("#"+tc+" "+value);
		}
	}
}
