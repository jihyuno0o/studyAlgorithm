import java.util.Scanner;

// 부분 수열의 합
public class Solution {
	static int N, K;
	static boolean[] sel; // 선택할지말지
	static int[] num; // 집합
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			} // 입력
			sel = new boolean[N];
			ans = 0;
			powerSetSum(0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	// n : 집합 수
	// idx : 현재 인덱스
	public static void powerSetSum(int idx) {
		if (idx == N) {
			// 합이 K가 되는 경우인지 확인
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					temp += num[i];
				}
			}
			if (temp == K) {
				ans++;
			}
		} else {
			sel[idx] = false; // idx 선택 안함
			powerSetSum(idx + 1); // 다음 인덱스로 넘어감
			sel[idx] = true; // idx 선택
			powerSetSum(idx + 1); // 다음 인덱스로 넘어감
		}
	}
}
