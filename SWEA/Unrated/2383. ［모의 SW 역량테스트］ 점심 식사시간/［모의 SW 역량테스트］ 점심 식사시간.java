import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Person{
		int r,c;
		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Stairs{
		int r,c;
		int len;
		public Stairs(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}
	static int[][] map;
	static int[] choice;
	static int minTotalTime = Integer.MAX_VALUE;
	static List<Person> pList;
	static List<Stairs> sList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			map = new int[N][N];
			pList = new ArrayList<>();
			sList = new ArrayList<>();
			minTotalTime = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) {
						pList.add(new Person(i,j));
					} else if(map[i][j] > 1) {
						sList.add(new Stairs(i,j,map[i][j]));
					}
				}
			}
			choice = new int[pList.size()];
			selectStairs(0);
			System.out.println("#"+tc+" "+minTotalTime);
		}
	}
	
	public static void selectStairs(int idx) {
		if(idx == pList.size()){
			minTotalTime = Math.min(minTotalTime, simulate());
			return ;
		}
		choice[idx] = 0;
		selectStairs(idx+1);
		choice[idx] = 1; 
		selectStairs(idx+1);
	}
	
	public static int simulate() {
		int totalMaxTime = 0;
		// 각 계단(0,1)에 대해 독립적으로 계산
		for(int sidx=0;sidx<2;sidx++) {
			PriorityQueue<Integer> arriveTimes = new PriorityQueue<>();
			for(int i=0;i<pList.size();i++) {
				// 각 사람이 계단 입구까지 도착하는 시간 dist 구하기
				if(choice[i] == sidx) {
					// 
					Person p = pList.get(i);
					Stairs s = sList.get(choice[i]);
					int dist = Math.abs(p.r - s.r) + Math.abs(p.c - s.c);
					arriveTimes.add(dist);
				}
			}
			
			if(arriveTimes.isEmpty()) continue;
			
			// 계단을 내려가는 사람들의 '완료 시간'을 저장하는 큐 
			List<Integer> downing = new ArrayList<>();
			int lastPersonTime = 0;

			while(!arriveTimes.isEmpty()) {
				int arriveTime = arriveTimes.poll();
				int entryTime = arriveTime+1;
				
				if(downing.size() == 3) {
					// 계단 꽉 참 
					int fastestExit = downing.get(0);
					if(entryTime < fastestExit) {
						entryTime = fastestExit;
					}
					downing.remove(0);
				}
				
				int exitTime = entryTime + sList.get(sidx).len;
				downing.add(exitTime);
				lastPersonTime = exitTime;
			}
			
			totalMaxTime = Math.max(totalMaxTime,  lastPersonTime);
		
		}
		return totalMaxTime;
	}
}
