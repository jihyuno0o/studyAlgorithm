import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//[모의 SW 역량테스트] 핀볼 게임
class pin {
	int[] start = new int[2];
	int[] now = new int[2];
	int foward;
	int point;

	public pin(int[] start, int[] now, int foward, int point) {
		super();
		this.start = start;
		this.now = now;
		this.foward = foward;
		this.point = point;
	}
}

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] blackhole = new int[2];
	static Map<Integer, int[]> warmhole;
	static int[][] map;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 0,상,하,좌,우
	static int[][] changeDir = { { 0, 0, 0, 0, 0 }, { 0, 0, 4, 1, 0 }, { 0, 4, 0, 2, 0 }, { 0, 3, 0, 0, 2 },
			{ 0, 0, 3, 0, 1 }, { 0, 0, 0, 0, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			warmhole = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == -1) { // 블랙홀
						blackhole[0] = i;
						blackhole[1] = j;
					} else if (map[i][j] > 5) { // 웜홀
						if (warmhole.containsKey(map[i][j])) {
							warmhole.get(map[i][j])[2] = i;
							warmhole.get(map[i][j])[3] = j;
						} else {
							warmhole.put(map[i][j], new int[] { i, j, 0, 0 });
						}
					}
				}
			} // 입력

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int k = 1; k <= 4; k++) {
							pinBall(new pin(new int[] { i, j }, new int[] { i, j }, k, 0));
						}
					}
				}
			}
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		} // tc
		System.out.println(sb);
	}

	static int newR, newC;

	public static void pinBall(pin pin) {
		while (true) {
			newR = pin.now[0] + dir[pin.foward][0];
			newC = pin.now[1] + dir[pin.foward][1];
			// 벽이면
			if (isWall(newR, newC)) {
				ans = Math.max(ans, pin.point * 2 + 1);
				return;
			}
			// 블랙홀, 출발자리 이면
			else if (map[newR][newC] == -1 || (newR == pin.start[0] && newC == pin.start[1])) {
				ans = Math.max(ans, pin.point);
				return;
			}
			
			switch(map[newR][newC]) {
			case 0: // 빈칸일때 넘어가
				break;
			case 1: case 2: case 3: case 4: case 5: // 블록일때
				if(changeDir[map[newR][newC]][pin.foward] == 0) { //블록의 편편한 부분에 부딪히면 끝남
					pin.point += 1;
					ans = Math.max(ans, pin.point * 2 - 1);
					return;
				}
				else { // 아니면 방향 바꿔줌
					pin.foward = changeDir[map[newR][newC]][pin.foward];
					pin.point += 1;
				}
				break;
			default: // 웜홀일때
				int[] wh = warmhole.get(map[newR][newC]);
				if (wh[0] == newR && wh[1] == newC) { // 1번 웜홀이 지금 위치, 2번으로 이동
					newR = wh[2];
					newC = wh[3];
				} else { // 현재 2번웜홀, 1번웜홀로 이동
					newR = wh[0];
					newC = wh[1];
				}
				break;
			}
			pin.now[0] = newR;
			pin.now[1] = newC;
		}
	}

	public static boolean isWall(int r, int c) { // 벽에 닿이면 true리턴
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return true;
		}
		return false;
	}

}