import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Microbe{
	int r, c, count, dir;
	public Microbe(int r,int c,int count, int dir) {
		this.r = r;
		this.c = c;
		this.count = count;
		this.dir = dir;
	}
}

public class Solution {
	static int[] dr = {0, -1,1,0,0}; // 상 하 좌 우 
	static int[] dc = {0, 0, 0, -1,1}; // 상 하 좌 우 
	static int[] reverse = {0, 2, 1, 4,3}; // 방향 반전 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			List<Microbe> mList = new ArrayList<>();
			int r, c, count, dir;
			for(int k=0;k<K;k++) {
				r = sc.nextInt();
				c = sc.nextInt();
				count = sc.nextInt();
				dir = sc.nextInt();
				mList.add(new Microbe(r,c,count,dir));
			}

			while(M-- > 0) {
				for(int i=0;i<mList.size();i++) {
					Microbe m = mList.get(i);
					m.r += dr[m.dir];
					m.c += dc[m.dir];
					// 가장자리 도달
					if(m.r == 0 || m.r == N-1 || m.c == 0 || m.c == N-1) {
						m.count /= 2;
						m.dir = reverse[m.dir];
						if(m.count == 0) {
							mList.remove(i--);
						}
					}
				}
				
				// 정렬 
				Collections.sort(mList, (m1,m2)->{
					if(m1.r != m2.r) return m1.r - m2.r;
					if(m1.c != m2.c) return m1.c - m2.c;
					return m2.count - m1.count;
				});
				
				for(int i=0;i<mList.size()-1;i++) {
					Microbe curr = mList.get(i);
					Microbe next = mList.get(i+1);
					if(curr.r == next.r && curr.c == next.c) {
						curr.count += next.count; 
						mList.remove(i+1);
						i--;
					}
				}
			}
			int result = 0;
			for(Microbe m : mList) {
				result += m.count;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
