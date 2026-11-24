import java.util.*;

public class Main{   
    public static int[][] grid = new int[51][51];
    public static int[][] visited = new int[51][51];
    public static int[] dist = new int[2501]; 
    public static int[][] dir = {{1,0,-1},{2,-1,0},{4,0,1},{8,1,0}};
    public static int N, M;
    public static void main(String[] args) {
        // 서(왼) 0001 
        // 북(위) 0010
        // 동(오) 0100
        // 남(아래) 1000 
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[M][N];
        visited = new int[M][N];
        dist = new int[M*N+1];

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == 0){
                    visited[i][j] = ++cnt;
                    dist[cnt] = 1;
                    find(i,j,cnt);
                    maxValue = Math.max(maxValue, dist[cnt]);
                }
            }
        }

    
        int maxAfterRemove = maxValue;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                maxAfterRemove = removeWall(i, j, maxAfterRemove);
            }
        }


        System.out.println(cnt);
        System.out.println(maxValue);
        System.out.println(maxAfterRemove);
    }

    public static void find(int i, int j, int value){
        int tmp = grid[i][j];
        int tr = 0; int tc = 0;
        for(int d=0;d<4;d++){
            if((tmp & dir[d][0]) == dir[d][0]){
                continue;
            } // 막힌 길 

            tr = i + dir[d][1];
            tc = j + dir[d][2];
            if(tr < 0|| tr >= M || tc < 0 || tc >= N) continue; 
            // 범위 밖 체크 
            if(visited[tr][tc] > 0) continue; // 방문 여부 체크 
            visited[tr][tc] = value;
            dist[visited[tr][tc]]++;
            find(tr,tc, value);
        }
    }

     public static int removeWall(int i, int j, int maxValue){
        int tmp = grid[i][j];
        int tr = 0; int tc = 0;
        for(int d=0;d<4;d++){
            if((tmp & dir[d][0]) != dir[d][0]){
                continue;
            } // 뚫린 길 

            tr = i + dir[d][1];
            tc = j + dir[d][2];

            if(tr < 0|| tr >= M || tc < 0 || tc >= N) continue; 
            // 범위 밖 체크 
            if(visited[i][j] == visited[tr][tc]) continue; // 같은 방일 경우 제외
            maxValue = Math.max(maxValue, dist[visited[i][j]] + dist[visited[tr][tc]]);
        }
        return maxValue;
    }
}