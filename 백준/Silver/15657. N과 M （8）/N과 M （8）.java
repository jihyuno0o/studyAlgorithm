import java.util.Arrays;
import java.util.Scanner;

// N과 M (8) 중복 조합 - 배열 입력받음
public class Main {
	static int N, M;
	static int[] num; // 입력받을 배열
	static int[] sel; // 조합 배열
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
			for (int n : sel) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		} else if (idx == N)
			return;

		sel[sidx] = num[idx]; // 일단 넣고
		Combination(idx, sidx + 1); // idx 부터 또 뽑을 수 있음
		Combination(idx + 1, sidx); // idx 다뽑으면 idx안뽑음

	}
}
