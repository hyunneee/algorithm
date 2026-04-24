import java.util.Scanner;

public class Main {

public static void main(String args[]) throws Exception
{
	Scanner sc = new Scanner(System.in);
	String[] alpha = new String[101];
	alpha = sc.nextLine().split("");
	int cnt = 0;
	for(int i=0;i<alpha.length ;i++) {
		// System.out.println("alpha[i] = "+alpha[i]);
		if (i == alpha.length-1) {
			 cnt++;
		} else {
			if (alpha[i].equals("c")) {
				if (alpha[i+1].equals("=")) {
					i++;
				}
				else if(alpha[i+1].equals("-")) {
					i++;
				}
			} else if (alpha[i].equals("d")) {
				if (i < alpha.length -2 && alpha[i+1].equals("z") && alpha[i+2].equals("=")) {
					i+=2;
				}
				else if(alpha[i+1].equals("-")) {
					i++;
				}
			} else if (alpha[i].equals("l")) {
				if (alpha[i+1].equals("j")) {
					i++;
				}
			} else if (alpha[i].equals("n")) {
				if (alpha[i+1].equals("j")) {
					i++;
				}
			} else if (alpha[i].equals("s")) {
				if (alpha[i+1].equals("=")) {
					i++;
				}
				
			} else if (alpha[i].equals("z")){
				if (alpha[i+1].equals("=")) {
					i++;
				}
				
			}
			cnt++;			
		}
	}
	System.out.println(cnt);
	sc.close();
}
}