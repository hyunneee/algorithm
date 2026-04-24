import java.util.Scanner;

public class Main {

public static void main(String args[]) throws Exception
{
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	sc.nextLine();
	String[] Narr = new String[N];
	int[] Narrint = new int[N];
	Narr = sc.nextLine().split(" ");
	int v = sc.nextInt();
	sc.nextLine();
	int cnt = 0;
	for(int i=0;i<N;i++) {
		Narrint[i] = Integer.parseInt(Narr[i]);
		if (Narrint[i] == v) {
			cnt++;
		}
	}
	System.out.println(cnt);
	sc.close();
}
}