import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> nums = new LinkedList<>();
		for (int i = 0; i < N; i++)
			nums.add(i + 1);

		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int idx = K - 1;
		for (int i = 0; i < N - 1; i++) { // N까지 가면 0으로 나눠야하니까 N-1까지
			sb.append(nums.remove(idx)).append(", ");
			idx = (idx + K - 1) % (nums.size());
		}
		sb.append(nums.remove()).append('>'); // 마지막 남은 거 넣어주기

		System.out.println(sb.toString());

	}
}
