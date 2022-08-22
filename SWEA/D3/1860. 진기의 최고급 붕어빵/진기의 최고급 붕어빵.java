import java.util.Arrays;
import java.util.Scanner;

// 진기의 최고급 붕어빵
public class Solution {
	static int N, M, K;
	static int[] guest;

	static String isPossible() {
		int fishbread = 0; // 만들어진 붕어빵 수
		int idx = 0; // 손님 번호
		int time = 0;
		while (true) {
			while (time + M > guest[idx]) {
				if (fishbread-- == 0) {
					return "Impossible";
				}
				if (idx++ >= N - 1) {
					return "Possible";
				}
			}
			time += M;
			fishbread += K;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 손님 수
			M = sc.nextInt(); // M분마다
			K = sc.nextInt(); // K개 만든다
			guest = new int[N];
			for (int i = 0; i < N; i++) {
				guest[i] = sc.nextInt();
			}
			Arrays.sort(guest); // 손님이 도착한시간 빨리온순서로 정렬

			System.out.printf("#%d %s\n", t, isPossible());
		}

	}
}
