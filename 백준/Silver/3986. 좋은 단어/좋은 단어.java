import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i=0;i<N;i++) {
			char[] str = sc.next().toCharArray();
			Stack<Character> stk = new Stack<>();
			stk.push(str[0]);
			for(int j=1;j<str.length;j++) {
				char s = str[j];
				if(stk.isEmpty()) {
					stk.push(s);
					continue;
				}
				char temp = stk.pop();
				if(temp != s) {
					stk.push(temp);
					stk.push(s);
				}
			}
			if(stk.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
