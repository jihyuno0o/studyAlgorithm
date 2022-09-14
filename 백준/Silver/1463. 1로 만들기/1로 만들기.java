import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1로 만들기
public class Main {
	static boolean[] visited = new boolean[1000001]; // 방문 확인
	static int[] dp = new int[1000001]; // 연산 횟수 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		bfs(N);
	}

	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>(); // 큐 생성
		que.add(n);

		while (!que.isEmpty()) {
			int cur = que.poll(); // 현재 값
			if (cur == 1) {
				System.out.println(dp[1]);
				break;
			}

			if (cur % 3 == 0 && visited[cur / 3] == false) {
				que.add(cur / 3);
				visited[cur / 3] = true;
				dp[cur / 3] = dp[cur] + 1;
			}

			if (cur % 2 == 0 && visited[cur / 2] == false) {
				que.add(cur / 2);
				visited[cur / 2] = true;
				dp[cur / 2] = dp[cur] + 1;
			}

			if (cur - 1 > 0 && visited[cur - 1] == false) {
				que.add(cur - 1);
				visited[cur - 1] = true;
				dp[cur - 1] = dp[cur] + 1;
			}
		}
	}
}
