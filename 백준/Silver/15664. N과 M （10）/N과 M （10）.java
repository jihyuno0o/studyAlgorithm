import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// N과 M (10) 
public class Main {
	static int N, M;
	static int[] num;
	static int[] sel;
	static List<int[]> comb = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

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
		System.out.println(sb);

	}

	public static void Combination(int idx, int sidx) {
		if (sidx == M) {
			for (int i = comb.size() - 1; i >= 0; i--) {
				if (Arrays.equals(comb.get(i), sel)) {
					return;
				} // 같은게 있으면 return
			}
			// 없으면
			comb.add(sel.clone());
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		} else if (idx == N) {
			return;
		}

		sel[sidx] = num[idx];
		Combination(idx + 1, sidx + 1); // 뽑고,
		Combination(idx + 1, sidx); // 안뽑고
	}
}
