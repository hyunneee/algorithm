import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M,totalSum,cnt;
	static int[] list;
	static int[] combination;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N];
		int num = (N-1)*(N-2)*(N-3)/6;
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		combination = new int[N];
		comb(0,0);			
		System.out.println(totalSum);
	}
	public static void comb(int idx, int sidx) {
		
		if(sidx == 3 ) {
			int sum = 0;
			// System.out.print("anwer: ");
			for(int i=0;i<3;i++) {
				// System.out.print(combination[i]+" ");
				sum+= list[combination[i]];
				
			}
			// System.out.println();
			if(sum <= M && sum >= totalSum) {
				totalSum = sum;
			}
			return ;
		}
		else {
			if(idx <=N-3+sidx) {
				combination[sidx] = idx;
				comb(idx+1, sidx+1);
				comb(idx+1, sidx);
			}
		}
	}
	
}
