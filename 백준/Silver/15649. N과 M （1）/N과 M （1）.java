import java.util.Scanner;

// N과 M (1)
public class Main {
	static int[] num;
	static int[] sel;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		sel = new int[M]; // 임시로 저장할 배열
		visited = new boolean[N];

		Permutation(0);
		System.out.println(sb);
	}

	// idx : 해당 위치 숫자 뽑을지 말지
	public static void Permutation(int idx) {
		if (idx == M) {
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문
				sel[idx] = num[i];
				Permutation(idx + 1);
				visited[i] = false; // 방문지우기
			}
		}
	}
}
