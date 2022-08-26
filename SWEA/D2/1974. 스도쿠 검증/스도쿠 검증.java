import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 스도쿠 검증
public class Solution {
	static int[][] map = new int[9][9];

	public static int isPossible() {
		List<Integer> check = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			// 가로체크
			for (int j = 0; j < 9; j++) {
				if (!check.contains(map[i][j])) {
					check.add(map[i][j]);
				} else
					return 0;
			}
			check.clear();
			// 세로체크
			for (int j = 0; j < 9; j++) {
				if (!check.contains(map[j][i])) {
					check.add(map[j][i]);
				} else
					return 0;
			}
			check.clear();

			// 3*3 박스 체크
			if (i % 3 == 0) { // 0, 3, 6 행에서 시작
				for (int boxCnt = 0; boxCnt < 3; boxCnt++) { // 가로로 박스 세개
					for (int boxi = 0; boxi < 3; boxi++) { // 박스내에서 i
						for (int j = 0; j < 3; j++) { // 박스내에서 j
							if (!check.contains(map[i + boxi][3 * boxCnt + j])) {
								check.add(map[i + boxi][3 * boxCnt + j]);
							} else
								return 0;
						}
					}
					check.clear();
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력

			System.out.printf("#%d %d\n", t, isPossible());

		}
	}
}
