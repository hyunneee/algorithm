import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n=0;
		int k=0;
		int[] sum= new int[100];
		int num;
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		k=sc.nextInt();
		int[] pArr= new int[n];
		if(n==0) {
			System.exit(0);
			}
		for(int i=0;i<n;i++) {
			pArr[i]=sc.nextInt();
		}
		for(int i=0;i<=n-k;i++) {
			num=0;
			for(int j=i;j<i+k;j++) {
				num+=pArr[j];
			}
			sum[i]=num;
		}
		int max=-10000;
		for(int i=0;i<=n-k;i++) {
			if(sum[i]>max) {
				max=sum[i];
			}
		}
		System.out.println(max);
		System.exit(0);
	}

}