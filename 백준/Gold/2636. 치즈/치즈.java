import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int h;
	static int w;
	static int[][] cheese; // 입력 저장
	static boolean[][] air; // 공기 확인
	static int remainCheese = 0; // 남아있는 치즈 개수
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		cheese = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cheese[i][j] = sc.nextInt();
				if (cheese[i][j] == 1) {
					remainCheese++;
				}
			}
		} // 입력

		int time = 0;
		int before = 0;

		while (remainCheese != 0) {
			before = remainCheese;
			air = new boolean[h][w];
			checkAirArea(); // 공기 체크 (구멍빼고 공기만)
			for (int i = 1; i < h - 1; i++) {
				for (int j = 1; j < w - 1; j++) {
					if (cheese[i][j] == 1) { // 치즈일때
						for (int k = 0; k < 4; k++) {
							if (air[i + dir[k][0]][j + dir[k][1]]) { // 공기랑 닿였으면
								cheese[i][j] = 0; // 없애고
								remainCheese--;
								break;
							}
						}
					}
				}
			}
			time++;
		}

		System.out.println(time);
		System.out.println(before);

	}

	public static void checkAirArea() {
		Queue<int[]> que = new LinkedList<>();
		air[0][0] = true; // 0,0 은 무조건 공기니까
		que.offer(new int[] { 0, 0 });

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int newR = cur[0] + dir[i][0];
				int newC = cur[1] + dir[i][1];
				if (mapOK(newR, newC) && !air[newR][newC] && cheese[newR][newC] == 0) {
					air[newR][newC] = true;
					que.offer(new int[] { newR, newC });
				}
			}
		}
	}

	public static boolean mapOK(int r, int c) {
		if (r < 0 || c < 0 || r >= h || c >= w) {
			return false;
		}
		return true;
	}
}
