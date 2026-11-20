import java.util.*;

class Solution {
    public static boolean[][] visited = new boolean[101][101];
    public static int[][] dist = new int[101][101];
    public static int n = 0, m = 0;
    public int solution(String[] board) {
        int answer = 0; 
        n = board.length;
        m = board[0].length();
        dist = new int[n][m];
        visited = new boolean[n][m];
        int[] start = new int[2];
        int[] end = new int[2]; 
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                switch(board[i].charAt(j)){
                    case 'R':
                        start[0] = i;
                        start[1] = j;
                        dist[i][j] = 2;
                        break;
                    case 'G':
                        end[0] = i;
                        end[1] = j;
                        dist[i][j] = 3;
                        break;
                    case 'D':
                        dist[i][j] = -1;
                        break;
                    default:
                        dist[i][j] = 0;
                        break;
                };
            }
        } // char로 dist 저장하기 
        
        
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[i].length();j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        answer = bfs(start);

        return answer;
    }
    
    public static boolean inRange(int i,int j){
        return 0 <= i && i < n && 0 <= j && j < m;
    }
    
    public static int bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int tx = 0, ty = 0;
        visited[start[0]][start[1]] = true;
        q.add(new int[]{start[0],start[1], 0});
        while(!q.isEmpty()){
            int[] tmp = q.poll(); 
            // System.out.println("temp="+tmp[0]+" "+tmp[1]+" "+tmp[2]);
            if(dist[tmp[0]][tmp[1]] == 3){ // 3이 G임 
                return tmp[2];
            }
            for(int d=0;d<4;d++){
                tx = tmp[0] + dir[d][0];
                ty = tmp[1] + dir[d][1];
                if(!inRange(tx,ty)){
                    // 범위를 벗어남
                    continue;
                }
                if(dist[tx][ty] == -1) continue; 
                while(inRange(tx,ty) && dist[tx][ty] != -1){
                    tx += dir[d][0];
                    ty += dir[d][1];
                }
                tx -= dir[d][0];
                ty -= dir[d][1];
                if(visited[tx][ty]) continue;
                visited[tx][ty] = true;
                q.add(new int[]{tx, ty,tmp[2]+1});
            }
        }
        return -1;
    }
}