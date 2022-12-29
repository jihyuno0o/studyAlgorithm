import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 단지번호붙이기
public class Main {
	static int n;
	static char[][] map; // 입력
	static boolean[][] visited; // 방문처리
	static ArrayList<Integer> town = new ArrayList<>(); // 단지 수 저장
	static int cnt; // dfs돌면서 각 단지 수 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().trim().toCharArray();
		} // 입력받음

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					town.add(cnt);
				}
			}
		}
		Collections.sort(town);
//		Integer[] answer = town.toArray(new Integer[0]);
		int[] answer = town.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(answer.length);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (mapOK(nr, nc) && map[nr][nc] == '1' && !visited[nr][nc]) {
				dfs(nr, nc);
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
