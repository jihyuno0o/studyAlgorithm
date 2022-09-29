import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// [모의 SW 역량테스트] 점심 식사시간
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[][] map, stair1, stair2;
	static int[][] stairPos = new int[2][3];
	static int people;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			people = 0;
			map = new int[N][N];
			int stair = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						people++;
					} else if (map[i][j] > 1) {
						stairPos[stair][0] = i; // 계단 R
						stairPos[stair][1] = j; // 계단 C
						stairPos[stair][2] = map[i][j]; // 계단 길이
						stair++;
					}
				}
			} // 입력

			// 각 계단까지 거리 계산
			stair1 = new int[people][2];
			stair2 = new int[people][2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						calDistance(i, j, idx++);
					}
				}
			}

			ans = Integer.MAX_VALUE;
			// 조합
			for (int i = 0; i < 1 << people; i++) {
				// i가 1이면 s1으로 내려가고 0이면 s2로 내려감
				move(i);
			}
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		} // tc
		System.out.println(sb);
	} // main

	// 계단과 사람 사이 거리 계산
	public static void calDistance(int r, int c, int idx) {
		stair1[idx][0] = Math.abs(r - stairPos[0][0]) + Math.abs(c - stairPos[0][1]);
		stair1[idx][1] = idx;
		stair2[idx][0] = Math.abs(r - stairPos[1][0]) + Math.abs(c - stairPos[1][1]);
		stair2[idx][1] = idx;
	}

	// 조합에 따라 1계단, 2계단 나눠서 사람 내려감
	public static void move(int comb) {
		List<Integer> s1 = new ArrayList<>();
		List<Integer> s2 = new ArrayList<>();
		for (int i = 0; i < people; i++) {
			if ((comb & (1 << i)) > 0) { // 부분수열에 포함되면 s1으로 내려가
				s1.add(stair1[i][0]);
			} else { // 아니면 s2로 내려가
				s2.add(stair2[i][0]);
			}
		}
		Collections.sort(s1);
		Collections.sort(s2);

		ans = Math.min(Math.max(downStair(s1, stairPos[0][2]), downStair(s2, stairPos[1][2])), ans);
	}

	// 계단내려오면서 시간계산
	public static int downStair(List<Integer> stair, int len) {
		int[] onStair = new int[3];
		int idx = 0;
		for (int i = 0; i < stair.size(); i++) {
			if (onStair[idx] != 0 && onStair[idx] > stair.get(i)) {
				// 처음 3명이 아니거나, 계단에 있는 사람이 현재 도착한 사람 시간보다 크면(대기해야하면) - 갱신해줌
				onStair[idx] += len; // 계단길이만큼더해줌
			} else { // 처음 3명이거나, 대기할 필요가 없으면 그냥 넣어줌
				onStair[idx] = stair.get(i) + 1 + len;
			}
			if (++idx == 3) {
				idx = 0;
			}
		}

		int min = 0;
		for (int i = 0; i < 3; i++) { // 남은 배열에서 가장 큰 수 뽑기
			if (onStair[i] > min) {
				min = onStair[i];
			}
		}
		return min;
	}

}
