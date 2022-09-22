import java.util.Scanner;

// N-Queen
public class Main {
	static int N;
	static int[] map;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		ans = 0; // ans 초기화
		chess(0);
		System.out.println(ans);

	}

	public static void chess(int r) {
		if (r == N) { // 마지막줄까지 전부다 놨으니까
			ans++; // 경우의 수 추가
			return;
		}
		for (int i = 0; i < N; i++) { // 오른쪽으로 한칸씩 옮기면서 확인
			map[r] = i; // 퀸 놧다 확인

			if (isPossible(r, i))
				chess(r + 1); // 다음줄 chess
			// 어차피 덮어씌울거라 안지워도됨
		}

	}

	public static boolean isPossible(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (map[i] == c) // 같은 열에 있는지 체크
				return false;
			else if (Math.abs(i - r) == Math.abs(map[i] - c)) // 대각선체크, 기울기가 1이면 대각선상에 있음
				return false;
		}
		return true;
	}
}
