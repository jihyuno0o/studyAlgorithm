import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//적록색약
public class Main {
	static int n;
	static char[][] map;
	static int[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n]; // 알약 입력받음
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}

		visit = new int[n][n]; // 방문처리와 일차bfs처리
		int rgb = 0; // 적록색약이 아닌 사람의 묶음 수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0) { // 방문처리 안된 것
					int color = -1; // r, g
					if (map[i][j] == 'B') {
						color = 1; // b
					}

					rgb++; // 묶음 수 증가
					bfs_rgb(i, j, color); // 그룹처리 bfs
				}
			}
		}

		int notRgb = 0; // 적록색약인 사람의 묶음 수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] != 0) { // 방문처리 안된 것은 -1 이거나 1
					notRgb++;
					bfs_notRgb(i, j, visit[i][j]);
				}
			}
		}

		System.out.print(rgb);
		System.out.print(' ');
		System.out.println(notRgb);

	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void bfs_rgb(int r, int c, int color) { // 적록색약 아닌사람
		visit[r][c] = color;
		Queue<Integer[]> que = new LinkedList<>();
		que.offer(new Integer[] { r, c });

		while (!que.isEmpty()) {
			Integer[] cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if (mapOK(newR, newC) && visit[newR][newC] == 0 && map[r][c] == map[newR][newC]) {
					visit[newR][newC] = color;
					que.offer(new Integer[] { newR, newC, color });
				}
			}
		}

	}

	public static void bfs_notRgb(int r, int c, int color) { // 적록색약인사람
		visit[r][c] = 0;
		Queue<Integer[]> que = new LinkedList<>();
		que.offer(new Integer[] { r, c });

		while (!que.isEmpty()) {
			Integer[] cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if (mapOK(newR, newC) && visit[newR][newC] == color) {
					visit[newR][newC] = 0;
					que.offer(new Integer[] { newR, newC, color });
				}
			}
		}
	}

	public static boolean mapOK(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= n) {
			return false;
		}
		return true;
	}
}
