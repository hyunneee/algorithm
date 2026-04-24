import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i < n * 2; i++) {
			for (int j = 0; j < n * 2; j++) {
				if(i<=n) {
					if(j<n-i) {
						System.out.print(" ");						
					}
					else if (n-i <= j && j < n+i-1) {
						System.out.print("*");
					} 					
				} else {
					if(i-n > j) {
						System.out.print(" ");
					}
					else if(i-n<=j &&  j < n*2-(i-n+1)) {
						System.out.print("*");
					}
				}
			}
			
			System.out.println();
		}
	}
}