import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

// N과 M (12)
public class Main {
	static int N, M;
	static int[] num;
	static int[] sel;
	static Set<String> comb = new LinkedHashSet<>();
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

		Combination(0, 0);
		sb = new StringBuilder();
		for (String s : comb) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);

	}

	// 중복조합
	public static void Combination(int idx, int sidx) {
		if (sidx == M) {
			sb = new StringBuilder();
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			comb.add(sb.toString());
			return;
		} else if (idx == N)
			return;

		sel[sidx] = num[idx]; // 넣고
		Combination(idx, sidx + 1); // 숫자 다시 뽑을수있고
		Combination(idx + 1, sidx); // 그숫자안뽑고
	}
}
