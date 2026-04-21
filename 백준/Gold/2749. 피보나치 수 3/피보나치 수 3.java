import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long[][] matrics = new long[][] {{1,1},{1,0}};
		
		long[][] result = fibo(matrics, n);
		System.out.println(result[1][0]);
	}
	
	public static long[][] multiply(long[][] a, long[][] b) {
		long[][] res = new long[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					res[i][j] += (a[i][k] * b[k][j]);
					res[i][j] %= 1000000;
				}
			}
		}
		return res;
	}
	
	public static long[][] fibo(long[][] matrics, long exp) {
		if(exp < 2) return matrics;
		
		long[][] half = fibo(matrics, exp/2);
		long[][] res = multiply(half, half); // A^(n/2) * A(n/2)
		if(exp %2 == 1) {
			res = multiply(res, matrics);
		}
		return res;
	}
}
