import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 무선 충전
class Person {
	int r, c;
	int bc;
	boolean onBC;

	public Person(int r, int c, int bc, boolean onBC) {
		this.r = r;
		this.c = c;
		this.bc = bc;
		this.onBC = onBC;
	}

	@Override
	public String toString() {
		return "Person [r=" + r + ", c=" + c + ", bc=" + bc + ", onBC=" + onBC + "]";
	}
}

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int ans, M, BCNum;
	static int[] A, B;
	static int[][] BC;
	static boolean[][][] map;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 0(이동x)상우하좌
	static Person a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			stk = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(stk.nextToken());
			BCNum = Integer.parseInt(stk.nextToken());
			A = new int[M+1];
			B = new int[M+1];
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(stk.nextToken());
			}
			stk = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(stk.nextToken());
			}
			
			BC = new int[BCNum][4];
			for (int i = 0; i < BCNum; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					BC[i][j] = Integer.parseInt(stk.nextToken());
				}
			} // 입력
			Arrays.sort(BC, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[3] - o1[3]; // 성능내림차순
				}

			});
			
			map = new boolean[BCNum][10][10];
			// 지도에 배터리 표시
			BCMarking();
			
			ans = 0; // 초기화 
			a = new Person(0, 0, -2, false);
			b = new Person(9, 9, -1, false);
			move();
			
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		} // tc
		System.out.println(sb.toString());
	}// main

	public static void move() {

		for (int i = 0; i <= M; i++) {// m초 동안 이동
			for (int j = 0; j < BCNum; j++) {
				// A이동
				if (map[j][a.r][a.c]) {
					if(!a.onBC) { // 안갔으면 일단 가 
						a.bc = j;
						a.onBC = true;
					}
					else { // 갔는데 
						if(a.bc == b.bc) { // b랑겹치는지 체크
							a.bc = j;
							break;
						}
					}
				}
				// B이동
				if (map[j][b.r][b.c]) { // 안갔으면 일단 가 
					if (!b.onBC) {
						b.bc = j;
						b.onBC = true;
					} else { // 갔는데 
						if(a.bc == b.bc) {// a랑겹치는지 체크
							b.bc = j;
							break;
						}
					}
				}
			}
			// AB 이동 끝
			if (a.onBC && b.onBC && a.bc == b.bc) {
				ans += BC[a.bc][3];
			} else {
				if (a.onBC) {
					ans += BC[a.bc][3];
				}
				if (b.onBC) {
					ans += BC[b.bc][3];
				}
			}
			a.onBC = false; // 초기화
			b.onBC = false;
			a.bc = -2;
			b.bc = -1;
			a.r += dir[A[i]][0]; // 이동
			a.c += dir[A[i]][1];
			b.r += dir[B[i]][0];
			b.c += dir[B[i]][1];
		}
	}

	// 지도에 배터리 표시
	public static void BCMarking() {
		int start, end, top, bottom;
		for (int i = 0; i < BCNum; i++) {
			start = BC[i][0]-1; // 열 시작
			end = BC[i][0]-1;
			top = BC[i][1] - BC[i][2]-1; // 행 시작
			bottom = top + BC[i][2]*2;
			for (int j = top; j <= bottom; j++) {
				for (int k = start; k <= end; k++) {
					if (mapOk(j, k)) {
						map[i][j][k] = true;
					}
				}
				if (j < BC[i][1] - 1) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
		}
	}

	public static boolean mapOk(int r, int c) {
		if (r < 0 || c < 0 || r >= 10 || c >= 10) {
			return false;
		}
		return true;
	}

}
