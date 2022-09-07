import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 알고스팟
class Node {
	int r;
	int c;
	int wall;

	public Node(int x, int y, int wall) {
		this.r = x;
		this.c = y;
		this.wall = wall;
	}
}

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] mapCnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new char[N][M];
		mapCnt = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			Arrays.fill(mapCnt[i], 987654321); // max값으로 채우고 현재cnt와 비교해서 min으로 바꿔줌
		} // 입력
		bfs();
		System.out.println(mapCnt[N - 1][M - 1]);

	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0));
		mapCnt[0][0] = 0;

		while (!queue.isEmpty()) {
			Node pos = queue.poll();

			for (int i = 0; i < 4; i++) { // 상하좌우탐색
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];
				int wallCnt = pos.wall;

				// 범위체크
				if (nr < 0 | nr >= N | nc < 0 | nc >= M)
					continue;

				// 목적지면 저장된 값이랑 비교해서 더 작은값 저장
				if (nr == N - 1 && nc == M - 1) {
					mapCnt[nr][nc] = Math.min(wallCnt, mapCnt[nr][nc]);
					continue;
				}

				// 다음 칸이 벽이면
				if (map[nr][nc] == '1')
					wallCnt++;

				// 해당 칸에 wall 개수보다 현재 wallCnt가 적어야 그 칸으로 이동
				if (mapCnt[nr][nc] > wallCnt) {
					queue.add(new Node(nr, nc, wallCnt));
					mapCnt[nr][nc] = wallCnt;
				}
			}
		}

	}
}
