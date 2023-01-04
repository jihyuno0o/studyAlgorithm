import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토
public class Main {
	static int m;
	static int n;
	static int[][] box;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		box = new int[n][m]; // n행 m열

		Queue<Integer[]> que = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt();
				box[i][j] = temp;
				if (temp == 1) { // 시작할 때 익은 토마토 큐에 넣음
					que.offer(new Integer[] { i, j, 1 });
				}
			}
		}
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		while (!que.isEmpty()) { // bfs
			Integer[] cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];

				if (mapOK(newR, newC) && box[newR][newC] == 0) {
					box[newR][newC] = cur[2] + 1; // 하루씩 증가
					que.offer(new Integer[] { newR, newC, box[newR][newC] });
				}
			}
		}

		int ans = 0; // 큰 값 찾기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) { // 0 있으면 -1출력하고 끝
					System.out.println(-1);
					return;
				} else {
					ans = (box[i][j] > ans) ? box[i][j] : ans;
				}
			}
		}
		System.out.println(ans - 1);

	}

	public static boolean mapOK(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= m) {
			return false;
		}
		return true;
	}
}
