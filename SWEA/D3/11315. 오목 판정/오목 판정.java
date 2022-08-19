import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	static int N;
	static List<char[]> map;

	public static boolean isFive(int r, int c) {
		int cnt;

		if (c < N - 4) {
			// 열 체크
			cnt = 1;
			for (int i = 1; i < 5; i++) {
				if (map.get(r)[c + i] == '.') {
					break;
				}
				cnt++;
			}
			if (cnt == 5)
				return true;
		}

		// 행 체크
		if (r < N - 4) {
			cnt = 1;
			for (int i = 1; i < 5; i++) {
				if (map.get(r + i)[c] == '.') {
					break;
				}
				cnt++;
			}
			if (cnt == 5)
				return true;

			// 우하향 대각 체크
			if (c < N - 4) {
				cnt = 1;
				for (int i = 1; i < 5; i++) {
					if (map.get(r + i)[c + i] == '.') {
						break;
					}
					cnt++;
				}
				if (cnt == 5)
					return true;
			}

			// 우상향 대각 체크
			if (c >= 4) {
				cnt = 1;
				for (int i = 1; i < 5; i++) {
					if (map.get(r + i)[c - i] == '.') {
						break;
					}
					cnt++;
				}
				if (cnt == 5)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				map.add(sc.next().toCharArray());
			}

			String flag = "NO";
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map.get(i)[j] == 'o') {
						if (isFive(i, j)) {
							flag = "YES";
							break outer;
						}

					}
				}
			}

			System.out.printf("#%d %s\n", t, flag);
		}
	}
}
