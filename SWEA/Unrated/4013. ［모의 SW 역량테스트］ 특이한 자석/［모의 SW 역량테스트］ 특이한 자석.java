import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Magnatic{
		int[] mag = new int[8];
		int rIdx = 0;
		int dir = 0;
		public Magnatic() {}
		
		public void doRotate() {
			if(dir == 1) {
				int temp = mag[7];
				for(int i=7;i>0;i--) mag[i] = mag[i-1];
				mag[0] = temp;
			} else if(dir==-1) {
				int temp = mag[0];
				for(int i=0;i<7;i++) mag[i] = mag[i+1];
				mag[7] = temp;
			}
			dir = 0;
		}
	}

	static Magnatic[] mList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int K = sc.nextInt();
			mList = new Magnatic[4];
			for(int i=0;i<4;i++) {
				mList[i] = new Magnatic();
				for(int j=0;j<8;j++) {
					mList[i].mag[j] = sc.nextInt();
				}
			}
			for(int i=0;i<K;i++) {
				int num = sc.nextInt()-1;
				int dir = sc.nextInt();
				mList[num].dir = dir;
				rotate(num, dir);
			}
			
			// 점수 계산 (각 자석의 0번 인덱스가 화살표 위치)
            int res = 0;
            if (mList[0].mag[0] == 1) res += 1;
            if (mList[1].mag[0] == 1) res += 2;
            if (mList[2].mag[0] == 1) res += 4;
            if (mList[3].mag[0] == 1) res += 8;
			
            System.out.println("#"+tc+" "+res);
		}
	}
	
	public static void rotate(int num,int dir) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[4];

		q.add(num);
		mList[num].dir = dir;
		visited[num] = true;

		while(!q.isEmpty()) {
			int curr = q.poll();

			// 1. 왼쪽 자석 체크 
			int left = curr - 1;
			if(left >= 0 && !visited[left]) {
				if(mList[curr].mag[6] != mList[left].mag[2]) {
					mList[left].dir = -mList[curr].dir;
					visited[left] = true;
					q.add(left);
				}
			}
			
			// 2. 오른쪽 자석 체크 
			int right = curr + 1;
			if(right < 4 && !visited[right]) {
				if(mList[curr].mag[2] != mList[right].mag[6]) {
					mList[right].dir = -mList[curr].dir;
					visited[right] = true;
					q.add(right);
				}
			}
		}
		
		for(int i=0;i<4;i++) {
			mList[i].doRotate();
		}
	}
}
