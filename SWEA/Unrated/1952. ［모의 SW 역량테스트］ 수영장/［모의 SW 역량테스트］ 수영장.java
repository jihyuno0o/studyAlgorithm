import java.util.Scanner;

// [모의 SW 역량테스트] 수영장
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[] cost = new int[4];
	static int[] month = new int[12];
	static int minCost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt(); // 이용권
			}
			for (int i = 0; i < 12; i++) {
				month[i] = sc.nextInt(); // 이용계획
			} // 입력

			minCost = Integer.MAX_VALUE;
			for (int i = 0; i < 12; i++) {
				if (month[i] == 0)
					continue;
				swim(i, 0);
				break;
			}
			sb.append("#").append(t).append(' ').append(minCost).append('\n');
		} // tc
		System.out.println(sb);
	}

	public static void swim(int m, int c) {
		if (m >= 12) {
			if (minCost > c) {
				minCost = c;
			}
			return;
		}

		for (int i = m; i < 12; i++) {
			if (month[i] == 0)
				continue;
			// 1일권
			swim(i + 1, c + month[i] * cost[0]);
			// 1달권
			swim(i + 1, c + cost[1]);
			// 3달권
			swim(i + 3, c + cost[2]);
			// 1년권
			swim(i + 12, c + cost[3]);
			return;
		}

		// 12개월까지 다 돌았는데 m이 12보다 안커지면 (게을러서 하반기에 안갈수도있음)
		if (minCost > c) {
			minCost = c;
		}

	}

}
