import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		Stack<Integer> stk = new Stack<>();
		for(int i=0;i<k;i++) {
			int temp = sc.nextInt();
			if(temp == 0) {
				int removed = stk.pop();	
			} else {
				stk.push(temp);				
			}
		}
		int ans = 0;
		while(!stk.isEmpty()) {
			ans += stk.pop();
		}
		System.out.println(ans);
	}
}
