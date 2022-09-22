import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N과 N (9) 
public class Main {
	static int N, M;
	static int[] num;
	static int[] sel;
	static boolean[] visited;
	static List<int[]> perm = new ArrayList<>();
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
			for (int i = perm.size() - 1; i >= 0; i--) {
				if (Arrays.equals(perm.get(i), sel)) {
					return;
				}
			} // 같은게 있으면 return
			perm.add(sel.clone()); // 리스트에 넣고
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				sel[idx] = num[i];
				visited[i] = true;
				Permutation(idx + 1);
				visited[i] = false;
			}
		}

	}
}
