import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int maxScore = Integer.MIN_VALUE, N;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer> block;
		for(int tc=1;tc<=T;tc++) {
			maxScore = 0;
			N = sc.nextInt();
			block = new ArrayList<>();
			for(int i=0;i<N;i++) {
				block.add(sc.nextInt());
			} // 블록 입력받기 

			getScore(block, 0);
			
			System.out.println("#"+tc+" "+maxScore);
		}
	}
	
	public static void getScore(List<Integer> temp, int score) {
		if(temp.isEmpty()) {
			maxScore = Math.max(maxScore, score);
			return ;
		}
		
		for(int i=0;i<temp.size();i++) {
			int addedScore = 0;
			int right = i + 1;
			int left = i - 1;

			if (left >= 0 && right < temp.size()) {
	            addedScore = temp.get(left) * temp.get(right);
	        } else if (left >= 0) {
	            addedScore = temp.get(left);
	        } else if (right < temp.size()) {
	            addedScore = temp.get(right);
	        } else {
	            // 마지막 남은 블록을 터뜨릴 때
	            addedScore = temp.get(i);
	        }
			
			int removedValue = temp.remove(i);
			getScore(temp, score + addedScore);
			temp.add(i,removedValue);
		}
	}
}
