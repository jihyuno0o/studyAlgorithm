import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 인구 이동
public class Main {
	static int N;
	static int L; // ㅣ이상
	static int R; // r이하
	static int[][] A; // 땅
	static boolean[][] visit;
	static List<int[]> pos;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		} // 입력

		int ans = 0; // 이동한 날짜
		while (true) {
            sum = 0; // 초기화
			visit = new boolean[N][N]; // 하루가 바뀌면 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mapOK(i, j + 1) && !visit[i][j] && Math.abs(A[i][j] - A[i][j + 1]) >= L
							&& Math.abs(A[i][j] - A[i][j + 1]) <= R) {
						bfs(i, j); // 유니온 체크
					}
					if (mapOK(i + 1, j) && !visit[i][j] && Math.abs(A[i][j] - A[i + 1][j]) >= L
							&& Math.abs(A[i][j] - A[i + 1][j]) <= R) {
						bfs(i, j); // 유니온 체크
					}
				}
			}

			if (sum == 0 || pos.size() == 0) {
				break; // 없으면 스탑
			}

			ans++; // 있으면 ++ 해주고 또 돌기
		}
		System.out.println(ans);
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void bfs(int r, int c) {
		sum = A[r][c]; // 자기자신 ++
		pos = new LinkedList<>(); // 위치기억 -> 나중에 나눈 값으로 변경
		pos.add(new int[] { r, c });

		Queue<int[]> que = new LinkedList<>(); // bfs 큐 생성
		visit[r][c] = true; // 방문 처리 (하루)
		que.offer(new int[] { r, c });

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if (mapOK(newR, newC) && !visit[newR][newC] && Math.abs(A[cur[0]][cur[1]] - A[newR][newC]) >= L
						&& Math.abs(A[cur[0]][cur[1]] - A[newR][newC]) <= R) { // 차이가 l이하 r이상
					visit[newR][newC] = true;
					pos.add(new int[] { newR, newC });
					sum += A[newR][newC]; // sum에 ++
					que.offer(new int[] { newR, newC });
				}
			}
		}

		int union = sum / pos.size(); // sum 나누기 연합 수
		for (int i = 0; i < pos.size(); i++) {
			int[] cur = pos.get(i); // 좌표 위치에
			A[cur[0]][cur[1]] = union; // 평균 값 넣어줌
		}

	}

	public static boolean mapOK(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return false;
		}
		return true;
	}

}
