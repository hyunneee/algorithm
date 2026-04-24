import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < n * 2; i++) { // 9번 
			for (int j = 1; j < n * 2; j++) {
				int num = Math.abs(n - i) * 2;
				if (i <= n) { // 초반 
					if(j < i) {
						System.out.print(" ");						
					} else if(i <= j && j <= num+i) {
						System.out.print("*");						
					}
				} else { // 후반 
					if(j < 2*n-i) {
						System.out.print(" ");												
					}
					else if( 2*n-i <= j && j <= i) {
						System.out.print("*");												
					} 
				}
			}
			System.out.println();
		}
	}
}