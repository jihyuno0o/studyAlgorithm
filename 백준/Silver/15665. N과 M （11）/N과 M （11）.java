import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

// N과 M (11)
public class Main {
	static int N, M;
	static int[] num;
	static int[] sel;
	static Set<String> perm = new LinkedHashSet<>();
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		} // 입력
		Arrays.sort(num);
		Permutation(0);
		sb = new StringBuilder();
		for (String s : perm) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}

	public static void Permutation(int idx) {
		if (idx == M) {
			sb = new StringBuilder();
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			perm.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) { // 중복순열
			sel[idx] = num[i];
			Permutation(idx + 1);
		}
	}
}
