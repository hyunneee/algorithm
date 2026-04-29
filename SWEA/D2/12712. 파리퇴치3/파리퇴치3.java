import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] map;
        int[][] dr = {{-1,1,0,0},{-1,-1,1,1}};
        int[][] dc = {{0,0,-1,1},{-1,1,-1,1}};
 
        for(int testCase=1;testCase<=T;testCase++) {
            int maxCnt = Integer.MIN_VALUE;
            int N = sc.nextInt();
            int M = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    map[i][j] = sc.nextInt();
                }
            } // 입력 받기 
 
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    for(int k=0;k<2;k++) {
                        int cnt = map[i][j];
                        for(int m=1;m<M;m++) {
                            for (int d = 0; d < 4; d++) {
                                int tr = i + m * dr[k][d];
                                int tc = j + m * dc[k][d];
                                if (tr < 0 || tr >= N || tc < 0 || tc >= N)
                                    continue;
                                cnt += map[tr][tc];
                            }
                        }
                        if (maxCnt < cnt)
                            maxCnt = cnt;
//                      System.out.println(i+" "+j+" "+cnt);
                    }
                }
            }
             
            System.out.println("#"+testCase+" "+maxCnt);
        }
         
    }
}