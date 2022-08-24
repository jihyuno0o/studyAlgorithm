import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[][] output = new String[n][3];

			String[][] nums = new String[n][n];

			// input 받기
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					nums[i][j] = input[j];
				}
			}

			// 90도 돌리기
			for (int cnt = 0; cnt < 3; cnt++) {
				String[][] after = new String[n][n];
				for (int i = n; i > 0; i--) {
					for (int j = 0; j < n; j++) {
						after[j][n - i] = nums[i - 1][j];
					}
				}
				for (int j = 0; j < n; j++)
					output[j][cnt] = String.join("", after[j]);

				nums = after;
			}

			System.out.printf("#%d\n", t);
			for (int i = 0; i < n; i++) {
				System.out.println(String.join(" ", output[i]));
			}

		}
	}
}
