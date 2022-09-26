import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [S/W 문제해결 기본] 7일차 - 미로1
class pos {
	int r;
	int c;

	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int[] dr = { 1, -1, 0, 0 }; // 우, 하, 좌, 상
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map = new char[16][16];
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.next();
			for (int i = 0; i < 16; i++) {
				map[i] = sc.next().toCharArray();
			} // 입력
			visited = new boolean[16][16]; // 방문 초기화
			System.out.printf("#%d %d\n", t, maze());

		}
	}

	public static int maze() {
		Queue<pos> que = new LinkedList<>(); // 큐생성
		que.add(new pos(1, 1)); // 시작점 넣기
		visited[1][1] = true; // 시작점 방문

		while (!que.isEmpty()) { // 큐빌때까지
			pos p = que.poll(); // 꺼내기
			if (map[p.r][p.c] == '3') { // 3이면 도착했으니까
				return 1;
			}

			for (int i = 0; i < 4; i++) { // 갈수있는 방향 확인
				int newDr = p.r + dr[i];
				int newDc = p.c + dc[i];
				if (!visited[newDr][newDc] && map[newDr][newDc] != '1') { // 방문체크, 벽아닌지
					que.add(new pos(newDr, newDc));
					visited[newDr][newDc] = true;
				}
			}
		}
		return 0;
	}
}
