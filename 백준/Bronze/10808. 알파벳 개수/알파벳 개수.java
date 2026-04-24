import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alpha = new int[27];
		char[] str = sc.next().toCharArray();
		for (int i = 0; i < str.length; i++) {
			alpha[str[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i] + " ");
		}
	}
}
