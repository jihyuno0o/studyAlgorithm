import java.util.Scanner;

// 숫자를 정렬하자 - mergesort
public class Solution {
	static int[] num;
	static int N;
	static int[] sorted;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			num = new int[N];
			sorted = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			} // 입력

			mergeSort(0, N - 1);
			sb.append("#").append(t).append(' ');
			for (int n : num) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	public static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽시작
		int R = mid + 1; // 오른쪽시작
		int idx = left; // 정렬된 숫자인덱스
		while (L <= mid && R <= right) {
			if (num[L] <= num[R]) {
				sorted[idx++] = num[L++];
			} else {
				sorted[idx++] = num[R++];
			}
		}
		// 남은거 처리
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sorted[idx++] = num[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				sorted[idx++] = num[i];
			}
		}

		for (int i = left; i <= right; i++) {
			num[i] = sorted[i];
		} // num에 다시 넣어줘서 반환해준다
	}
}
