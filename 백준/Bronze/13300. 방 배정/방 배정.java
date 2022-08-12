import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] students = new int[7][2];

		for (int i = 0; i < n; i++) {
			if (sc.nextInt() == 0) {
				students[sc.nextInt()][0]++;
			} else {
				students[sc.nextInt()][1]++;
			}
		}

		int ans = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				// 학생 없으면 패스
				if (students[i][j] == 0)
					continue;

				if (students[i][j] <= k)
					ans++;
				// k로 딱 떨어지면
				else if (students[i][j] % k == 0)
					ans += (students[i][j] / k);
				// 딱 안 떨어지면
				else if (students[i][j] % k != 0) {
					ans += (students[i][j] / k);
					ans++;
				}
			}
		}

		System.out.println(ans);

	}
}
