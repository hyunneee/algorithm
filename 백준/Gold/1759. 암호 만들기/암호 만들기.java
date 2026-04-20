import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1759 암호만들기
public class Main {
	static int L, C;
	static char[] strList, str;
	static boolean[] isVowel;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		strList = new char[C];
		isVowel = new boolean[C];
		str = new char[L];
		for(int i=0;i<C;i++) {
			strList[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(strList);
		
		for(int i=0;i<C;i++) {
			switch(strList[i]){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				isVowel[i] = true;
				break;
			default:
				break;
			}
		}
		sb = new StringBuilder();
		comb(0,0,0);
		System.out.println(sb.toString());
	}
	
	public static void comb(int cnt, int sidx, int vCnt){
		if(cnt >= L){
			if((vCnt>=1) && (cnt-vCnt >= 2)) {
				for(char c : str) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return ;
		}
		if(sidx >= C) return ;
		str[cnt] = strList[sidx];
		if(isVowel[sidx]) {
			comb(cnt+1, sidx+1,vCnt+1);
		} else {
			comb(cnt+1, sidx+1,vCnt);
		}
		comb(cnt, sidx+1,vCnt);
	}
	
}
