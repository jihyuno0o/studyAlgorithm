import java.util.Scanner;

// 준홍이의 카드놀이
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M;
		int[] count;
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			count = new int[N + M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					count[i + j]++; // N+M 이 나왔다고 체크
				}
			}

			int max = 0; 
			for (int i = 0; i < count.length; i++) {
				if (count[i] > max) {
					max = count[i]; // 가장 많이 나온 카드가 몇장나왔는지 확인
				}
			}

			System.out.print("#" + t);
			for (int i = 0; i < count.length; i++) {
				if (count[i] == max) { // 가장 많이 나왔다면 프린트
					System.out.print(" " + i);
				}
			}
			System.out.println();
		}
	}
}
