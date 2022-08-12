import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			// 버블 정렬
//			for (int i = N - 1; i > 0; i--) {
//				for (int j = 0; j < i; j++) {
//					if (nums[j] > nums[j + 1]) {
//						int temp = nums[j];
//						nums[j] = nums[j + 1];
//						nums[j + 1] = temp;
//					}
//				}
//			}

			// 선택 정렬
			for (int i = 0; i < N - 1; i++) {
				int minIdx = i;
				for (int j = i + 1; j < N; j++) {
					if (nums[minIdx] > nums[j]) {
						minIdx = j;
					}
				}
				int temp = nums[i];
				nums[i] = nums[minIdx];
				nums[minIdx] = temp;
			}
			
			System.out.printf("#%d ", t);
			for (int n : nums) {
				System.out.printf("%d ", n);
			}
			System.out.println();
		}
	}
}
