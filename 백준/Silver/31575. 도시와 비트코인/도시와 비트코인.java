import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean isTrue = false;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0,0});

        while(!stack.isEmpty()) {
            int[] curr = stack.pop();
            if(visited[curr[0]][curr[1]]) continue;
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == (M - 1) && curr[1] == (N - 1)) {
                isTrue = true;
                break;
            }
            if (curr[0] > M || curr[1] > N) {
                continue;
            }
            if (curr[1] + 1 < N && map[curr[0]][curr[1] + 1] == 1) {
                // 오른쪽에 길이 있음
                stack.add(new int[] {curr[0], curr[1]+ 1});
            }
            if (curr[0] + 1 < M && map[curr[0] + 1][curr[1]] == 1) {
                // 아래쪽에 길이 있음
                stack.add(new int[] {curr[0]+1, curr[1]});
            }
        }
        if(isTrue)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
