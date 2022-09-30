import java.util.Scanner;

// [모의 SW 역량테스트] 벽돌 깨기
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, W, H, ans;
	static int[][] map;
	static int[][] copy; // 복사할거
	static boolean[] done;
	static int[] sel; // 터뜨릴 행 선택

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 입력받기
			N = sc.nextInt();
			W = sc.nextInt(); // 열
			H = sc.nextInt(); // 행
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 중복순열 뽑기 (구슬떨어뜨릴 곳 뽑기)
			sel = new int[N];
			ans = Integer.MAX_VALUE; // 초기화
			permutaion(0);
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		} // tc
		System.out.println(sb);
	}

	public static void permutaion(int idx) { // 중복조합
		if (idx == N) {
			// 구슬 떨어뜨리기 실행
			dropMarble(sel);

			return;
		}

		for (int i = 0; i < W; i++) {
			sel[idx] = i;
			permutaion(idx + 1);
		}
	}

	public static void dropMarble(int[] marbles) {
		done = new boolean[W];
		copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			copy[i] = map[i].clone();
		}
		int brickC = 0, brickR = 0, brickNum = 0;
		for (int i = 0; i < N; i++) {
			brickC = marbles[i];
			if (done[brickC])
				break; // 그 줄이 빈 줄이라면 구슬 떨어뜨릴 필요 없음, 다른조합으로 시도
			for (int j = 0; j < H; j++) {
				if (copy[j][brickC] > 0) { // 위에서부터 내려오면서
					brickR = j; // 제일 위 블럭 찾기
					brickNum = copy[brickR][brickC]; // 벽돌에 적힌 숫자
					break;
				}
			}
			// 벽돌깨뜨리기
			breakBrick(brickR, brickC, brickNum);
			dropBrick();
		}

		ans = Math.min(ans, cntBrick());
	}

	static int[] di = { -1, 1 };

	public static void breakBrick(int r, int c, int n) {
		// 본인 0으로 만들기
		copy[r][c] = 0;
		if (n == 1)
			return;
		// 세로줄은 0으로 만들기
		for (int i = 1; i < n; i++) {
			if (r + di[0] * i >= 0) { // 위로
				breakBrick(r + di[0] * i, c, copy[r + di[0] * i][c]);
			}
			if (r + di[1] * i < H) { // 아래로
				breakBrick(r + di[1] * i, c, copy[r + di[1] * i][c]);
			}
		}

		// 가로 줄은 한줄씩 위에서 내림
		for (int i = 1; i < n; i++) {
			int newC = c + di[0] * i;
			if (newC >= 0) { // 왼쪽
				breakBrick(r, newC, copy[r][newC]);
			}
			newC = c + di[1] * i;
			if (newC < W) { // 오른쪽
				breakBrick(r, newC, copy[r][newC]);
			}
		}
	}

	public static void dropBrick() {
		for (int i = 0; i < W; i++) {
			int idx = H - 1;
			while (idx >= 0) {
				if (copy[idx][i] != 0) { // 0이아니면 넘어가
					idx--;
					continue;
				}
				// 0이면 0아닌 다음 숫자 찾기
				for (int j = idx; j >= 0; j--) {
					if (copy[j][i] != 0) {
						copy[idx][i] = copy[j][i]; // 숫자 넣고
						copy[j][i] = 0; // 비워주고
						break;
					}
				}
				idx--;

			} // while
			if (copy[H - 1][i] == 0)
				done[i] = true;
		} // W다돌고
	}

	public static int cntBrick() { // 남은 벽돌 세기
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copy[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
