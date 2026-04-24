import java.util.Scanner;

public class Main {
	static int maxNum = 1200000;
	static boolean[] isnotPrime = new boolean[maxNum + 1];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		res = 0;
		primeCheck();
		for (int i = n;i<=maxNum; i++) {
			if (!isnotPrime[i]) {
				if (isPelindrome(i))
					break;
			}
		}
		System.out.println(res);
	}

	public static void primeCheck() {
		isnotPrime[0] = true;
		isnotPrime[1] = true;
		for (int i = 2; i < Math.sqrt(maxNum); i++) {
			if (!isnotPrime[i]) {
				for (int j = i * i; j <= maxNum; j+=i) {
					isnotPrime[j] = true;
				}
			}
		}
	}

	public static boolean isPelindrome(int num) {
		char[] cArr = Integer.toString(num).toCharArray();
		for (int i = 0; i < cArr.length / 2; i++) {
			if (cArr[i] == cArr[cArr.length - 1 - i])
				continue;
			else {
				return false;
			}
		}
		res = num;
		return true;
	}
}
