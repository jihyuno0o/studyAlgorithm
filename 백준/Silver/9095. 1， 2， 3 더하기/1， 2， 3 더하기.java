import java.util.Scanner;

// 1, 2, 3 더하기
public class Main {
	static int[] dp = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp[1] = 1; // 1
		dp[2] = 2; // 2, 1+1
		dp[3] = 4; // 2+1, 1+1+1, 1+2, 3

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			System.out.println(sumMethodCnt(N));

		}

	}

	public static int sumMethodCnt(int n) {
		if (dp[n] != 0)
			return dp[n];

		else {
			// dp[n]은 n-1한 숫자 뒤에 1을 붙인 경우의 수와
			// n-2한 숫자 뒤에 2를 붙인 경우의 수와
			// n-3한 숫자 뒤에 3을 붙인 경우의 수를 더한 값
			dp[n] = sumMethodCnt(n - 1) + sumMethodCnt(n - 2) + sumMethodCnt(n - 3);
			return dp[n];
		}
	}
}
