import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 회의실 배정
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		// 뒤에거가 빠른거를 먼저 정렬
		// 뒤에거가 같으면
		// 앞에거가 빠른거를 먼저 정렬

		int ans = 1;
		int cur = time[0][1];
		for (int i = 1; i < n; i++) {
			if (time[i][0] >= cur) {
				ans++;
				cur = time[i][1];
			}
		}

		System.out.println(ans);
	}
}
