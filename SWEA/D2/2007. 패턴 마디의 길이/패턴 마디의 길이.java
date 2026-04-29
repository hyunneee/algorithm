import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			char[] pattern = str.substring(0, 10).toCharArray();

			int ln = 2;
			for(ln = 2;ln<=10;ln++) { // 마디 길이별로 계산하기 
				boolean isLength = true;
				for(int i=ln;i<=2*ln;i++) { 
					if(pattern[i-ln] != str.charAt(i)) {
						isLength = false;
						break;
					}
				}
				if(isLength) break;
			}
			System.out.println("#"+tc+" "+ln);
		}
	}
}
