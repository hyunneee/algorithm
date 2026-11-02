import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        char init = grid[0][0]; // 초기 
        int cnt = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=1;i<R-1;i++){
            for(int j=1;j<C-1;j++){
                // 1,1~ R-1,C-1 범위에서 0,0의 값과 다른 문자 찾기 
                if(grid[i][j] != init){
                    // 동일하지 않다. == 이동할 수 있음 
                    arr.add(new int[]{i,j});
                }
            }
        } //  한 번 이동함 
        for(int[] temp : arr){
            // 2번째로 이동함 
            for(int i=temp[0]+1;i<R-1;i++){
                for(int j=temp[1]+1;j<C-1;j++){
                    if(init == grid[i][j]){
                        // init 이 'W' 라면 temp('B')로 이동해서 이동할 수 있는거는 다시 'W'가 됨 
                        cnt++;
                    }
                }
            }
        }
        System.out.println(grid[0][0] == grid[R-1][C-1] ? 0 : cnt);
    }
}