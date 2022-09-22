import java.util.Arrays;
import java.util.Scanner;

// 숫자를 정렬하자 - quicksort : Hoare - Partition
public class Solution {
	static int[] num;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			} // 입력

			quickSort(0, N - 1);
			sb.append("#").append(t).append(' ');
			for (int n : num) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = HoarePartition(left, right);
			quickSort(left, pivot - 1); // 반으로쪼개기
			quickSort(pivot + 1, right);
			// merge가 필요없음
		}
	}

	public static int HoarePartition(int left, int right) {
		int pivot = num[left]; // 제일왼쪽값 pivot
		int L = left + 1; // 왼쪽 시작
		int R = right; // 오른쪽 시작
		while (L <= R) { // 교차되면 멈춤
			while (L <= R && num[L] <= pivot) { // pivot 보다 작으면 그대로 둘거니까
				L++;
			}
			while (num[R] > pivot) { // pivot 보다 크면 그대로 둘거니까
				R--;
			}
			if (L < R) { // L : 피봇보다 큰값 , R :피봇보다 작은값
				swap(L, R);
			}
		}
		swap(left, R);
		return R;
	}

	public static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
