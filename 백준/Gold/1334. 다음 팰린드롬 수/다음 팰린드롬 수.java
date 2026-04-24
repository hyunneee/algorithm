import java.util.Scanner;

public class Main {
	
	static char exp = '9'+1;
	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		char[] arr=sc.nextLine().toCharArray();
		StringBuilder p_num = new StringBuilder();
		
		int_method_plus(arr.length-1,arr);

		int mid=(arr.length-1)/2;
		
		if(arr[0]==exp) {//9만으로 이루어진 것 해결햊구기
			p_num.append("1");
			for(int i=0;i<arr.length-1;i++)
				p_num.append("0");
			p_num.append("1");
			System.out.println(p_num);
			return;
		}
	
		int front_idx;
		if(arr.length%2==0)
			front_idx=mid;
		else 
			front_idx=mid-1;
		int back_idx=mid+1;
		for(;front_idx>=0;front_idx--,back_idx++) {
			if(arr[front_idx]==arr[back_idx])
				continue;
			else if(arr[front_idx]>arr[back_idx])
				break;
			else {
				int_method_plus(mid,arr);
				break;}
			}
		
		for(int i=0;i<arr.length/2;i++) 
			p_num.append(arr[i]);
		
		if(arr.length%2==0)
			p_num.append((""));
		else 
			p_num.append(arr[mid]);
		
		for(int i=arr.length/2-1;i>=0;i--) {
			p_num.append(arr[i]);
		}

		System.out.println(p_num);
		}

		
		static void int_method_plus(int idx, char[] arr) {
			int target = idx;
			while(true){
				if(arr[target]=='9') {
					if(target!=0) {
						arr[target]='0';
						target--;
					}
					else {
						arr[target]=exp;
						break;
					}
				}
				else {
					arr[target]+=1;
					break;
			}
		}
	}
}