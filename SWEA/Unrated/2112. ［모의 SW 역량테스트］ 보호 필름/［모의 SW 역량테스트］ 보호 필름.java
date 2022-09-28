import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int R, C, K;
	static int[][] cells;
	static int[][] check;
	static int[] sel;
	static boolean[] visited;
	static int minAns;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			K = sc.nextInt();
			cells = new int[R][C];
			sel = new int[R];
			visited = new boolean[R];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					cells[i][j] = sc.nextInt(); // 안바뀔 배열
				}
			}
			flag = false;
			minAns = 987654321; // 초기화
			sol();
			System.out.printf("#%d %d\n", t, minAns);
		} // tc

	}

	public static void sol() {
		int ans = 0;
		while (true) {
			Combination(0, 0, ans);
			if(flag) {
				break;
			} 
			else {
				ans++;
			}
		}
	}

	public static void Combination(int idx, int sidx, int M) {
		if (sidx == M) {
			check = new int[R][C];
			for(int i=0; i<R; i++) {
				check[i] = cells[i].clone();
			}
			addChemical(sel, M, 0);
			if(flag && M < minAns) {
				minAns = M;
			}
			return;
		} else if (idx == R)
			return;
		
		sel[sidx] = idx; // 일단 넣고
		Combination(idx + 1, sidx + 1, M); // idx인덱스 숫자 선택
		Combination(idx + 1, sidx, M); // idx인덱스 숫자 선택 x

	}

	public static void addChemical(int[] sel, int M, int idx) {
		if (idx == M || M == 0) {
			if(checkCell(check)) {
				flag = true;
			}
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			Arrays.fill(check[sel[idx]], i); // 이걸로 바꿔줌
			addChemical(sel, M, idx + 1);
		}

	}

	// K개 이상 없는 cell 이 있는지 반환
	public static boolean checkCell(int[][] arr) {
		for (int i = 0; i < C; i++) {
			if (!performance(i, arr)) {
				return false;
			}
		}
		return true; // 정상
	}

	// 세로 cell 이 K개 이상 연속적으로 있는지 없는지 반환
	public static boolean performance(int c, int[][] arr) {
		int cnt = 1;
		int start = arr[0][c]; // 시작
		for (int i = 1; i < R; i++) {
			if (start == arr[i][c]) { // 시작이랑 같으면 ++
				cnt++;
			} else { // 달라지면 0부터 시작
				start = arr[i][c];
				cnt = 1;
			}

			if (cnt == K) { // k개되면 성능통과
				return true;
			}
		}

		return false;
	}
}
