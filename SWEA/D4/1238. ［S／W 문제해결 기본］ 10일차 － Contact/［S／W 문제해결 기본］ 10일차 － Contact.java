import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 10일차 - Contact
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, start;
	static int[][] adj; // 근접배열 저장
	static int max; 
	static boolean[] visited;
	static int[] depth; // 레벨 저장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			adj = new int[101][101];
			visited = new boolean[101];
			depth = new int[101];
			max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			} // 입력
			bfs(start);
			findMax();
			sb.append("#").append(t).append(' ').append(max).append('\n');
		} // tc
		System.out.println(sb);

	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		depth[start] = 1; // 시작 레벨
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < 101; i++) {
				if (!visited[i] && adj[cur][i] == 1) {
					queue.add(i);
					depth[i] = depth[cur]+1; // 부모의 레벨을 저장
					visited[i] = true;
				}
			}
		}
	}

	public static void findMax() { // 제일큰값찾기
		int level = 0;
		for(int i=0; i<101; i++) {
			if (depth[i] >= level && i > max) {
				level = depth[i];
				max = i;
			}
		}
	}
}
