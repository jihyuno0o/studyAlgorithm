package swea;

import java.util.Scanner;

public class p1208 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			
			//sort 안쓰기
			for (int i = 0; i < dump; i++) {
				for (int j = 0; j < 99; j++) {
					for (int k = 0; k < 99 - j; k++) {
						if (box[k] > box[k + 1]) {
							int tmp = box[k];
							box[k] = box[k + 1];
							box[k + 1] = tmp;
						}
					}
				}
				if (box[99] - box[0] == 0) {
					break;
				}
				box[99] = box[99] - 1;
				box[0] = box[0] + 1;

			}

			System.out.printf("#%d %d\n", t, Math.max(box[99], box[98]) - Math.min(box[0], box[1]));
		}

	}
}
