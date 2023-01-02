import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//유기농 배추
public class Main {
	static int m; // 가로
	static int n; // 세로
	static int k; // 배추개수
	static int[][] map; // 배추밭

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			map = new int[m][n];

			for (int i = 0; i < k; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 1;
			} // 배추 위치 입력받음

			int ans = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						ans++;
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
		} // 테스트케이스 개수
	} // main

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void bfs(int r, int c) {
		Queue<Integer[]> que = new LinkedList<>();

		que.offer(new Integer[] { r, c });
		map[r][c]++; // 방문처리

		while (!que.isEmpty()) {
			Integer[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];

				if (mapOK(newR, newC) && map[newR][newC] == 1) {
					map[newR][newC]++; // 방문처리
					que.offer(new Integer[] { newR, newC });
				}
			}
		}
	}

	public static boolean mapOK(int r, int c) {
		if (r < 0 || c < 0 || r >= m || c >= n) {
			return false;
		}
		return true;
	}
}
