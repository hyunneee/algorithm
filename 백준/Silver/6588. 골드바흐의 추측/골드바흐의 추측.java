import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 골드바흐의 추측 
public class Main {
	static boolean[] notPrime = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		notPrime[0] = notPrime[1] = true;
		boolean flag = false;
		for (int k = 2; k < Math.sqrt(1000000); k++) {
			if (!notPrime[k]) {
				for (int l = k; k * l <= 1000000; l++)
					notPrime[k * l] = true;
			}
		}
		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			for (int i = 3; i <= n / 2; i++) {
				if (!notPrime[i] && !notPrime[n - i]) {
					sb.append(n + " = " + i + " + " + (n - i) + "\n");
					flag = true;
					break;
				}
			}
			if (!flag)
				sb.append("Goldbach's conjecture is wrong.\n");
			else
				flag = false;
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
		
	}
}
