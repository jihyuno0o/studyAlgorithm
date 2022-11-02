import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = 0;
	static String[][] map; // 방 정보 저장
	static int[] robot = new int[3]; // 좌표x,y ,방향
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북,동,남,서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < 3; i++) {
			robot[i] = Integer.parseInt(stk.nextToken());
		}
		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		} // 입력

		run();
		System.out.println(ans);
	}

	static int dR, dC;

	public static void run() {
		if (map[robot[0]][robot[1]].equals("0")) { // 청소가 안된 곳이라면
			ans++;
			map[robot[0]][robot[1]] = "-1"; // 청소함으로 바꿔줌
		}

		for (int i = 0; i < 4; i++) {
			robot[2] = (robot[2] + 3) % 4; // -1해주면 인덱스 에러나니까 +3해줌
			dR = robot[0] + dir[robot[2]][0];
			dC = robot[1] + dir[robot[2]][1];
			if (map[dR][dC].equals("0")) { // 청소가 안된 곳이라면
				robot[0] = dR; // 이동
				robot[1] = dC; // 이동
				run();
				return;
			}
		} // 4방향 탐색 다함

		// 다 돌았는데도 청소할 곳이 없다면 뒤로 백
		dR = robot[0] + dir[(robot[2] + 2) % 4][0];
		dC = robot[1] + dir[(robot[2] + 2) % 4][1];
		if (!map[dR][dC].equals("1")) { // 벽이 아니면
			robot[0] = dR;
			robot[1] = dC;
			run();
			return;
		}
	}

}
