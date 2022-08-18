import java.util.Scanner;

// 퍼펙트 셔플
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] cards = new String[N];

			for (int i = 0; i < N; i++) {
				cards[i] = sc.next();
			}
			
			System.out.printf("#%d ", t);
			if ((N % 2) == 0) { // 짝수일때 
				for (int i = 0; i < (N / 2); i++) {
					System.out.print(cards[i] + " ");
					System.out.print(cards[i + (N / 2)] + " ");
				}
			} else { // 홀수일때
				for (int i = 0; i < (N / 2); i++) {
					System.out.print(cards[i] + " ");
					System.out.print(cards[i + 1 + (N / 2)] + " "); // 홀수일때는 앞덱스가 하나 많으니까 +1 해줌
				}
				System.out.print(cards[(N / 2) ]); // 앞덱스의 마지막 숫자
			}
            System.out.println();
		}
	}
}
