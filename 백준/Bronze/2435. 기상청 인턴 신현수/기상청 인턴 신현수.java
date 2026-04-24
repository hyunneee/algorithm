import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n=0, k=0; //변수 n,k 선언
		int[] sum= new int[100]; //합들을 모아둘 배열 선언
		int num; //더할 때 사용할 변수 선언
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt(); //n,k 입력받기
		k = sc.nextInt();
		int[] pArr= new int[n]; //온도 받기 위한 배열 선언
		for(int i=0;i<n;i++) { //n개의 온도를 받아주기 위한 반복문
			pArr[i]=sc.nextInt();
		}
		for(int i=0;i<=n-k;i++) { //연속적인 k일의 온도를 구하는 경우의 수 n-k+1
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