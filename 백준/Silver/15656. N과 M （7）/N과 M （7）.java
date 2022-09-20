import java.util.Arrays;
import java.util.Scanner;

// N과 M (7) 중복 순열 - 배열 입력받음
public class Main {
	static int N, M;
	static int[] num; // 숫자 배열
	static int[] sel; // 순열 배열
	static boolean[] visited; // 방문 체크
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		} // 입력
		Arrays.sort(num);

		Permutation(0);
		System.out.println(sb);
	}

	public static void Permutation(int idx) {
		if (idx == M) {
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			sel[idx] = num[i];
			Permutation(idx + 1);
			visited[i] = false;
		}
	}
}
