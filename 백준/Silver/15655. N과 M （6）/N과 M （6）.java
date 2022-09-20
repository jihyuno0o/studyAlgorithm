import java.util.Arrays;
import java.util.Scanner;

// N과 M (6) 조합 - 배열 입력받음
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

	// idx : 인덱스 고를지말지
	// sidx : 선택한 인덱스 위치
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
		Combination(idx + 1, sidx + 1); // idx 뽑아
		Combination(idx + 1, sidx); // idx 안뽑아

	}
}
