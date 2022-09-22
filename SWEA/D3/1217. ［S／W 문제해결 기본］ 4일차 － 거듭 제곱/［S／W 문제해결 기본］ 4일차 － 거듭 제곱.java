import java.util.Scanner;

// [S/W 문제해결 기본] 4일차 - 거듭 제곱
public class Solution {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.next();
			N = sc.nextInt();
			M = sc.nextInt();
			sb.append("#").append(t).append(' ').append(powerOfN(N, M)).append('\n');
		}
		System.out.println(sb);
	}

	public static int powerOfN(int n, int m) {
		if (m == 0) {
			return 1;
		} else if (m == 1) {
			return n;
		}

		int result;
		if (m % 2 == 0) {
			result = powerOfN(n, m / 2);
			return result * result;
		} else {
			result = powerOfN(n, (m - 1) / 2);
			return result * result * n;
		}
	}
}
