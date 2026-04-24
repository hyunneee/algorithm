
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.MAX_VALUE;
		String[] s = br.readLine().split("-");
		
		for(int i=0;i<s.length;i++) {
			int tmp = 0;
			String[] add = s[i].split("\\+");
			for(int j=0;j<add.length;j++) {
				tmp += Integer.parseInt(add[j]);
			}
			if(sum==Integer.MAX_VALUE) {
				sum = tmp;
			}
			else {
				sum -=tmp;
			}
			
		}
		System.out.println(sum);
	}
}
