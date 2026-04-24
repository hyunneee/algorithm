import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N + 1][N + 1];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
		} // 사과 위치 저장하기

		int L = Integer.parseInt(br.readLine());
		int[] Sec = new int[L + 1];
		char[] Dir = new char[L + 1];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Sec[i] = Integer.parseInt(st.nextToken());
			Dir[i] = st.nextToken().charAt(0);

		} // 사과 위치 저장하기
		int totalSec = 0;
		int curX = 1, curY = 1;
		int[] dirX = { 0, 1, 0, -1 }; // +1하면 오른쪽, -1하면 왼쪽
		int[] dirY = { 1, 0, -1, 0 };
		int dIdx = 0;
		int slen = 1;
//		int[][] snake = new int[N*N+1][2];
		Deque<int[]> snake = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		int secIdx = 0;
		int x = 0;
		visited[1][1] = true;
		snake.add(new int[] {1,1});
		while (true) {
			x++;
			curX = curX + dirX[dIdx];
			curY = curY + dirY[dIdx];
			if (curX <= 0 || curY <= 0 || curX > N || curY > N || visited[curX][curY]) {
				totalSec = x;
				break;
			} // 방문한 위치거나 벽 부딪혔어요
			int[] temp = new int[] { curX, curY };
			snake.addFirst(temp);
			visited[curX][curY] = true;

			if (map[curX][curY]) { // 사과 있어요
				map[curX][curY] = false;
//				System.out.println("사과 있다능.." + curX + " " + curY);
			} else {
				if (!snake.isEmpty()) {
					temp = snake.removeLast();
					visited[temp[0]][temp[1]] = false;
				}
			}
			if (x == Sec[secIdx]) {
				if (Dir[secIdx] == 'L') {
					dIdx = (dIdx + 3) % 4; // -1
//					System.out.println("L이다 요놈아.." + curX + " " + curY);
				} else {
					dIdx = (dIdx + 5) % 4; // +1
//					System.out.println("D이다 요놈아.." + curX + " " + curY);
//					System.out.println("잠시만 snake 길이 확인하고 가실게요");
//					for(int i=0;i<slen;i++) {
//						System.out.print(snake[i][0]+" "+snake[i][1]+" |  ");
//					}
//					System.out.println();
				}
				secIdx++;
			}
		}

		System.out.println(x);
	}
}
