import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Character> front = new Stack<>();
		Stack<Character> rear = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) { // 테스트 케이스 
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				if(c == '-') {
					if(!front.isEmpty()) {
						front.pop();
					}
				}
				else if(c== '<') {
					if(!front.isEmpty()) {
						rear.push(front.pop());
					}
				} else if(c== '>') {
					if(!rear.isEmpty()) {
						front.push(rear.pop());
					}
				} else {
					front.push(c);
				}
			}
			sb = new StringBuilder("");
			for(char ch : front) sb.append(ch);
			while(!rear.isEmpty()){
				sb.append(rear.pop());
			}
			front.clear();
			System.out.println(sb.toString());
		}
	}
}
