import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 창용 마을 무리의 개수
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] adj;
	static boolean[] visited;
	static int group;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][b] = 1;
				adj[b][a] = 1;
			} // 입력

			group = 0;
			for (int i = 1; i <= N; i++) { // 사람 1번부터  N번까지
				if (!visited[i]) {
					bfs(i);
					group++;
				}
			}
			sb.append("#").append(t).append(' ').append(group).append('\n');
		} // tc
		System.out.println(sb);
	}// main

	public static void bfs(int person) {
		Queue<Integer> que = new LinkedList<>();
		que.add(person);
		visited[person] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[cur][i] == 1) {
					que.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
