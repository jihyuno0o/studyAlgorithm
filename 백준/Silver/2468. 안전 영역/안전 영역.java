import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안전 영역
public class Main {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer stk;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		} // 입력

		int ans = 1;
		for (int h = 1; h <= 100; h++) {
			visited = new boolean[N][N]; // 높이마다 visited 배열 초기화
			int safe = 0; // 높이마다 안전지대 개수 저장 변수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) { // h보다 높은 숫자에 방문처리가 안되어있으면 새로운 안전지대 구역
						visited[i][j] = true; // 방문처리하고
						countSafeZone(h, i, j); // dfs돌기
						safe++; // 안전지대 개수 +1
					}
				}
			}
			ans = Math.max(ans, safe); // 총 안전지대 max값 갱신
		}

		System.out.println(ans);

	}

	public static void countSafeZone(int h, int r, int c) { // 처음들어오는 i, j와 이어지는 안전지대에 visited처리해줌
		for (int i = 0; i < 4; i++) { // 4방향 탐색
			int newDr = r + dr[i];
			int newDc = c + dc[i];
			if (!mapOk(newDr, newDc)) { // 범위 탐색
				continue;
			}

			if (!visited[newDr][newDc] && map[newDr][newDc] > h) {
				visited[newDr][newDc] = true;
				countSafeZone(h, newDr, newDc);
			}
		}
	}

	public static boolean mapOk(int r, int c) { // 범위 탐색
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}
}
