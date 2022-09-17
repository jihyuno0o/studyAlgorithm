import java.util.Scanner;

// 2*n 타일링 2
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[10001];
		dp[1] = 1; // 2*1 일때
		dp[2] = 3; // 2*2 일때

		System.out.println(tile(dp, n) % 10007);
	}

	public static int tile(int[] dp, int n) {
		if (dp[n] != 0) {
			return dp[n];
		} else {
			// | 와 = 와 ㅁ 이 앞에 온 경우로 나눠서 생각할 수 있다
			// | 가 앞에 온 경우 n-1의 경우의 수
			// = 가 앞에 온 경우 n-2의 경우의 수
			// ㅁ 이 앞에 온 경우 n-2의 경우의 수
			dp[n] = tile(dp, n - 1) % 10007 + tile(dp, n - 2) % 10007 + tile(dp, n - 2) % 10007;
			return dp[n];
		}
	}
}
