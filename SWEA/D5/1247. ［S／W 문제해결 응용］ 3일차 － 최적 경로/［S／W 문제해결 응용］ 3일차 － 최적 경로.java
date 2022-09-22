import java.util.Scanner;

// [S/W 문제해결 응용] 3일차 - 최적 경로
public class Solution {
	static int N;
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] customer;
	static boolean[] visited;
	static int minDistance;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			for (int i = 0; i < 2; i++) {
				company[i] = sc.nextInt();
			}
			for (int i = 0; i < 2; i++) {
				home[i] = sc.nextInt();
			}
			customer = new int[N][2];
			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			} // 입력

			visited = new boolean[N];
			minDistance = 987654321; // maxInteger;
			permutation(0, 0, -1);
			sb.append("#").append(t).append(' ').append(minDistance).append('\n');
		} // tc
		System.out.println(sb);
	}

	// idx : 뽑은개수
	// sel : 전에 뽑은 집 위치
	public static void permutation(int idx, int distance, int sel) {
		// 기저조건
		if (idx == N) {
			distance += Visit(sel, -1); // 집으로 가야함
			if (distance < minDistance) { // 최소값 갱신
				minDistance = distance;
			}
			return;
		}
		// mindis보다 크면 더 돌필요없음
		if (distance >= minDistance) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문처리하고
				permutation(idx + 1, distance + Visit(sel, i), i);
				visited[i] = false; // 방문처리 지워죠
			}
		}
	}

	private static int Visit(int before, int after) {
		int beforeX = (before < 0) ? company[0] : customer[before][0];
		int beforeY = (before < 0) ? company[1] : customer[before][1];
		int afterX = (after < 0) ? home[0] : customer[after][0];
		int afterY = (after < 0) ? home[1] : customer[after][1];

		return Math.abs(beforeX - afterX) + Math.abs(beforeY - afterY);
	}
}
