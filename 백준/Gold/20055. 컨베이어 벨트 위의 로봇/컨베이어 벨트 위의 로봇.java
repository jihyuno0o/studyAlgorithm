import java.util.Scanner;

// 컨베이어 벨트 위의 로봇
public class Main {
	static int N, K, ans;
	static boolean[] robot;
	static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		robot = new boolean[N];
		A = new int[2 * N];
		for (int i = 0; i < 2 * N; i++) {
			A[i] = sc.nextInt();
		} // 입력
		ans = 0;
		factory();
		System.out.println(ans);
	}

	public static void factory() {
		while (isValid()) {
			int temp = A[2 * N - 1];
			for (int i = 2 * N - 1; i > 0; i--) {
				A[i] = A[i - 1];
			}
			A[0] = temp; // 내구도 회전 , 오른쪽으로

			for (int i = N - 1; i > 0; i--) { // 로봇회전
				robot[i] = robot[i - 1];
			}
			robot[0] = false; // 시작위치 비워줘
			robot[N - 1] = false; // 도착위치 내려

			for (int i = N - 2; i >= 0; i--) { // 먼저 벨트에 올라간 로봇부터
				if (robot[i] && !robot[i + 1] && A[i + 1] > 0) { // 해당자리에 로봇이 있고, 이동할자리에 로봇이 없고, 내구도가 1이상
					robot[i + 1] = true;
					robot[i] = false;
					A[i + 1] -= 1;
				}
			}

			if (A[0] > 0) { // 시작위치 내구도 0이상이면 로봇 올린다
				robot[0] = true;
				A[0] -= 1;
			}
			ans++;
		}

	}

	public static boolean isValid() { // 내구도가 0칸인 개수가 K개 이상인지 확인
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (A[i] == 0) {
				cnt++;
			}
			if (cnt >= K) {
				return false;
			}
		}
		return true;
	}

}
