import java.util.Scanner;

// N-Queen
public class Solution {
	static int N;
	static int[][] map;
	static int ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			ans = 0; // ans 초기화

			chess(0, 0);
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}

	public static void chess(int r, int c) {
		if (r == N) { // 마지막줄까지 전부다 놨으니까
			ans++; // 경우의 수 추가
			return;
		}
		for (int i = 0; i < N; i++) { // 오른쪽으로 한칸씩 옮기면서 확인
			if (!isPossible(r, i)) { // 퀸 못놓으면 패스
				continue;
			} else {
				map[r][i] = 1; // 퀸 놧다 확인
				chess(r + 1, i); // 다음줄 chess
				map[r][i] = 0; // 퀸 지우기
			}
		}

	}

	public static boolean isPossible(int r, int c) {
		int left = c, right = c; // 행을 기준으로 대각선이 줄었다 늘었다 하니까 변수 저장
		
		while (r >= 0) { // 위로만 확인해도 됨
			if (map[r][c] == 1) {
				return false;
			}
			if (left >= 0 && map[r][left] == 1) {
				return false;
			}
			if (right < N && map[r][right] == 1) {
				return false;
			}
			r--;
			left--;
			right++;
		}
		return true;
	}
}
