import java.util.Scanner;

// 스타트와 링크
public class Main {
	static int N;
	static int[][] S;
	static boolean[] startTeam;
	static int min = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N][N];
		startTeam = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		} // 입력

		Combination(0, 0);
		System.out.println(min);
	}

	// idx : 인덱스 선택할지 안할지
	// sidx : N/2 되면 능력치 차이 계산
	public static void Combination(int idx, int sidx) {
		if (sidx == N / 2) { // startTeam에서 절반 뽑으면
			int start = 0, link = 0;
			for (int i = 0; i < N; i++) {
				if (startTeam[i]) { // 스타트팀 선수이면
					for (int j = 0; j < N; j++) {
						if (i != j && startTeam[j]) {
							start += S[i][j];
						}
					}
				} else { // 스타트팀 선수 아니면
					for (int j = 0; j < N; j++) {
						if (i != j && !(startTeam[j])) {
							link += S[i][j];
						}
					}
				}
			} // 능력치 합 계산
			min = Math.min(min, Math.abs(start - link)); // 차이 최소값
			return;
		} else if (idx == N)
			return;

		startTeam[idx] = true;
		Combination(idx + 1, sidx + 1); // idx 뽑고
		startTeam[idx] = false;
		Combination(idx + 1, sidx); // idx 안뽑고
	}
}
