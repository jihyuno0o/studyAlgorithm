import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			for (int i = 0; i < dump; i++) {
				Arrays.sort(box);
				if (box[99] - box[0] == 0) {
					break;
				}
				box[99] = box[99] - 1;
				box[0] = box[0] + 1;

			}
			Arrays.sort(box);
			System.out.printf("#%d %d\n", t, box[99] - box[0]);
		}

	}
}
