import java.util.Scanner;

// 부분수열의 합
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		} // 입력
		int ans = 0;
		for (int i = 1; i < 1 << N; i++) { // 부분수열의 개수 1<<N == 2<<N-1
			int sum = 0;
			for (int j = 0; j < N; j++) { // N인덱스랑 비교하면서
				if ((i & (1 << j)) > 0) { // i랑 j자리에 있는 애가 i부분수열에 포함되는 애라면
					sum += num[j];
				}
			}
			if (sum == S)
				ans++;
		}
		System.out.println(ans);
	}
}
