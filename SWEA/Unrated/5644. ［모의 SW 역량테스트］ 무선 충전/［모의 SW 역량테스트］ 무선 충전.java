import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class AP{
		int r,c, dist, p;
		public AP(int r, int c, int dist, int p) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.p = p;
		}
	}
	static int[] userA, userB;
	static int[][] result, map;
	static AP[] apList;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			map = new int[11][11];
			userA = new int[M];
			userB = new int[M];
			result = new int[M+1][2];
			for(int i=0;i<M;i++) {
				userA[i] = Integer.parseInt(st.nextToken());
				userB[i] = Integer.parseInt(st2.nextToken());
			} // userA,B의 경로 저장 
			apList = new AP[A];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				apList[i] = new AP(r,c,dist,p);
			}// ap 기기 저장 
			int[] uA = new int[] {1,1};
			int[] uB = new int[] {10,10};
			int totalSum = 0;
			for(int i=0;i<=M;i++) {
				// 현재 가능한 충전 A 기기 확인 
				List<Integer> listA = getAvailableBC(uA);
				List<Integer> listB = getAvailableBC(uB);
				
				// 최댓값 구해서 결과에 더하기 
				totalSum += getMax(listA, listB);
				
				// 사용자 위치 갱신 
				if(i<M) {
					uA[0] += dr[userA[i]];
					uA[1] += dc[userA[i]];
					uB[0] += dr[userB[i]];
					uB[1] += dc[userB[i]];
				}
				
			} // M초 반복 
			System.out.println("#"+tc+" "+totalSum);
		}
	}
	
	public static boolean calculDist(int[] user, AP temp) {
		return Math.abs(user[0] - temp.r) + Math.abs(user[1] - temp.c) <= temp.dist ? true : false;
	}
	
	public static List<Integer> getAvailableBC(int[] user) {
		List<Integer> temp = new ArrayList<>();
		for(int t=0;t<apList.length;t++) {
			if(calculDist(user,apList[t])) {
				temp.add(t);
			}
		}
		return temp;
	}
	
	public static int getMax(List<Integer> listA, List<Integer>  listB) {
		int maxCharge = 0;
		if (listA.isEmpty()) listA.add(-1);
	    if (listB.isEmpty()) listB.add(-1);
	    
	    for(int aBC : listA) {
			for(int bBC : listB) {
				int sum = 0;
				if(aBC == bBC) {
					// 같은 기기 선택 
					if (aBC != -1) sum = apList[aBC].p;
				} else {
					sum += (aBC != -1 ? apList[aBC].p : 0);
					sum += (bBC != -1 ? apList[bBC].p : 0);
				}
				maxCharge = Math.max(maxCharge, sum);
			}
		}
		return maxCharge;
	}
}
