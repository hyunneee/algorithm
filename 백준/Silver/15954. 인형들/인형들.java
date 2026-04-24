import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		double min_v;
		min_v = cal(n,k,arr);
		
		System.out.println(String.format("%.11f",min_v));
		}
	
	public static double cal(int n, int k,int[] arr) {
		double sum=0, mean=0, stdv=Integer.MAX_VALUE, v=0;	
		while(k<=n) {
				for(int i=0;i<=n-k;i++) {
					sum=0;
					for(int j=i;j<i+k;j++) {
						sum+=arr[j];
					}
					mean=sum/k;
					sum=0;
					for(int j=i;j<i+k;j++) {
						sum+=Math.pow(arr[j]-mean,2);
					}
					stdv=Math.min(stdv,Math.sqrt(sum/k));
				}
				k++;
			}
			return stdv;
		}
	}