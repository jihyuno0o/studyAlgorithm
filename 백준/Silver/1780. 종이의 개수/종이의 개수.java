import java.util.Scanner;

// 종이의 개수
public class Main {
	static int[][] paper;
	static int N;
	static int[] ans = new int[3]; // -1(+1해서 0인덱스), 0(+1해서 1인덱스), 1(+1헤서 2인덱스)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				paper[i][j] = sc.nextInt();
			}
		} // 입력

		papercut(1, N+1, 1, N+1);

		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);

	}

	public static void papercut(int rStart, int rEnd, int cStart, int cEnd) {
		// 종이가 모두 같은 수가 아니면 9개로 쪼갬
		if (!checkSameNumber(rStart, rEnd, cStart, cEnd)) {
			int cut = (rEnd - rStart) / 3; // 3등분할 숫자
			for (int i = rStart; i < rEnd; i += cut) {
				for (int j = cStart; j < cEnd; j += cut) {
					papercut(i, i + cut, j, j + cut); // 9개로 나눈다
				}
			}
		}
		// 종이가 모두 같은 수로 되어 있으면 ans++ return
		else {
			ans[paper[rStart][cStart] + 1]++; // -1(+1해서 0인덱스), 0(+1해서 1인덱스), 1(+1헤서 2인덱스)
			return;
		}
	}

	public static boolean checkSameNumber(int rStart, int rEnd, int cStart, int cEnd) {
		int num = paper[rStart][cStart]; // 처음 시작 숫자와
		for (int i = rStart; i < rEnd; i++) {
			for (int j = cStart; j < cEnd; j++) {
				if (num != paper[i][j]) // 다른 숫자가 나오면
					return false; // false 반환
			}
		}
		return true;
	}
}
