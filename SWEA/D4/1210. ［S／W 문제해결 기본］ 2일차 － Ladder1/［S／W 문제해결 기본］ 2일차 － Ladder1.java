import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 2일차 - Ladder1
class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			br.readLine();
			int[][] map = new int[100][100];
			for (int i = 99; i >= 0; i--) { // 사다리를 뒤집어서 2부터 시작해서 도착지점 찾기
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 사다리 입력

			int col = -1; // 2가 들어있는 시작지점
			for (int i = 0; i < 100; i++) {
				if (map[0][i] == 2) {
					col = i;
					break;
				}
			} // 시작지점 찾음

			int row = 0;
			while (row < 99) { // 젤 아래로 내려갈때까지
				if (col - 1 >= 0 && map[row][col - 1] == 1) { // 현재 row에서 왼쪽에 갈 곳 있는지 확인
					for (int i = col - 1; i >= 0; i--) { // 있다면 현재 row에서 왼쪽으로 쭉 따라가다가
						if (map[row + 1][i] == 1) { // 다시 내려갈길을 만나면
							col = i; // col 인덱스 변경
							break;
						}
					}
				} 
				else if (col + 1 < 100 && map[row][col + 1] == 1) { // 현재 row에서 오른쪽쪽에 갈 곳 있는지 확인
					for (int i = col + 1; i < 100; i++) { // 있다면 현재 row에서 오른쪽으로 쭉 따라가다가
						if (map[row + 1][i] == 1) { // 다시 내려갈길을 만나면
							col = i; // col 인덱스 변경
							break;
						}
					}
				}
				row++; // 아래로 한줄 내려감
			}
			System.out.println("#" + t + " " + col);
		}
	}
}
