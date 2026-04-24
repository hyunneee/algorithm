import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt(); // 파일의 개수 
		
		String pat=sc.next(); //패턴 
		
		int idx=pat.indexOf('*'); //*의 인덱스알아내기 
		
		String pat_front = pat.substring(0,idx); //*앞에 있는 문자열 만들기 
		String pat_back = pat.substring(idx+1); //*에 있는 문자열 만들기 
		
		int pat_front_len = pat_front.length(); //*앞 개수 세기 
		int pat_back_len = pat_back.length(); //*뒤 개수 세기 
		int len=pat.length()-1; //*제외한 총 개수 세기 
		
		for(int i=0;i<n;i++) { //테스트 개수만큼 
			String test=sc.next(); //테스트 입력받기 
			
			int test_len=test.length(); //테스트 길이 
			
			if(test_len<len) { //이게 총 길이보다 작으면 성립X 
				System.out.println("NE");
			}
			else {
				String test_front=test.substring(0,pat_front_len); //테스트*앞
				String test_back=test.substring(test_len-pat_back_len); //테스트*뒤
				
				if(test_front.equals(pat_front)&&test_back.equals(pat_back)) //앞뒤 같으면 
					System.out.println("DA");
				else
					System.out.println("NE");
			}
		}
		System.exit(0);
	}
}