import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static int H, W; // 맵의 세로, 가로
	static char[][] map;
	static int nowR, nowC; // 현재 차의 위치

	static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dc[] = { 0, 0, -1, 1 };
	static int dI; // 현재 인덱스 방향의 위치 (차의 방향)
	static Map<Character, Integer> carStatus = new HashMap<>();

	public static void makeMap() {
		carStatus.put('^', 0);
		carStatus.put('v', 1);
		carStatus.put('<', 2);
		carStatus.put('>', 3);
	}

	public static void move(char command) { // 이동하는 메소드
		switch (command) {
		case 'U':
			dI = 0;
			break;
		case 'D':
			dI = 1;
			break;
		case 'L':
			dI = 2;
			break;
		case 'R':
			dI = 3;
			break;
		}
		if (nowR + dr[dI] < 0 || nowR + dr[dI] >= H || nowC + dc[dI] < 0 || nowC + dc[dI] >= W) {
			return; // 범위벗어나면 return
		}
		if (map[nowR + dr[dI]][nowC + dc[dI]] == '.') { // 평지일때
			nowR += dr[dI]; // 이동
			nowC += dc[dI];
		}

	}

	public static void shoot(int dir) { // 총쏘는 메소드
		int newR, newC;
		int idx = 1; // 벽만나지 않으면 계속 갈꺼니까
		while (true) {
			newR = nowR + dr[dir] * idx; // 해당 방향으로 이동
			newC = nowC + dc[dir] * idx;
			if (newR < 0 || newR >= H || newC < 0 || newC >= W) { // 범위 벗어나면
				return; // return
			}
			if (map[newR][newC] == '*') { // 벽돌벽이면
				map[newR][newC] = '.'; // 평지됨
				return; // 포탄소멸
			} else if (map[newR][newC] == '#') { // 강철벽이면
				return; // 포탄 소멸
			}
			idx++; // 한방향 더 이동
		}
	}

	public static void main(String[] args) {
		makeMap(); // carStatus 맵 생성
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String str;
		int N; // 명령어의 수
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W]; // 맵 생성

			for (int i = 0; i < H; i++) {
				str = sc.next(); // 한줄씩 읽고
				for (int j = 0; j < W; j++) {
					if (str.charAt(j) == '<' || str.charAt(j) == '>' || str.charAt(j) == '^' || str.charAt(j) == 'v') {
						dI = carStatus.get(str.charAt(j)); // 차 방향 저장
						map[i][j] = '.'; // 평지로 바꾸고
						nowR = i; // 위치 기억
						nowC = j; // 위치 기억
						continue;
					}
					map[i][j] = str.charAt(j); // 차 아닐땐 맵에 바로 저장
				}
			} // 입력

			N = sc.nextInt(); // 명령어의 수
			str = sc.next(); // 명령어
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) == 'S') { // shoot 일때
					shoot(dI);
				} else { // 이동방향 일때
					move(str.charAt(i));
				}
			}

			for (char key : carStatus.keySet()) { // 현재 차 상태가 방향 숫자로 저장되어 있으므로
				if (carStatus.get(key) == dI) { // 해당 키와 현재 방향이 맞는 value 찾아서
					map[nowR][nowC] = key; // 현재 방향에 맞는 차 모양 갖다 넣기
				}
			}

			System.out.printf("#%d ", t);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}
