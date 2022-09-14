import java.util.Scanner;

// 카드 구매하기 2
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N + 1]; // N개의 카드팩 가격
		for (int i = 1; i < N + 1; i++) {
			card[i] = sc.nextInt();
		} // 입력

		int[] dp = new int[N + 1]; // N개를 고르는 가장 싼 가격 저장
		dp[1] = card[1]; // 카드 한장을 고르는 가장 싼 가격은 card[1]을 고르는 것

		
		for (int i = 2; i < N + 1; i++) {
			int tempMin = 10000;
			for (int a = 1; a < i; a++) {
				for (int b = a; b < i; b++) {
					if (a + b == i) { // 합해서 i가 되는 a,b의 디피값을 더한다
						tempMin = Math.min(tempMin, dp[a] + dp[b]);
					}
				}
			}

			dp[i] = Math.min(tempMin, card[i]); // dp[i]는 여러개를 합해서 사는게 비싼지, N개의 카드팩을 사는게 비싼지
		}

		System.out.println(dp[N]);

	}

}
