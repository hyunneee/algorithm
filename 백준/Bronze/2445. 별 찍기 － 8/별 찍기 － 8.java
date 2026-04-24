import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < n * 2; i++) {
			for (int j = 0; j < n * 2; j++) {
				int num = Math.abs(n-i)*2;
				if(i<=n) {
					if(i<=j && j<n*2-i) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				} else {
					if(n*2-i<=j && j<i) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
	}
}