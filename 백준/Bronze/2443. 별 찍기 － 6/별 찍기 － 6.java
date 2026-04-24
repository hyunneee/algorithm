import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n*2 ; j++) {
				if(j < 2*n-i) {
					if(j > i) {
						System.out.print("*");					
					} else {
						System.out.print(" ");					
					} 
				}
			}
			System.out.println();
		}
	}
}
