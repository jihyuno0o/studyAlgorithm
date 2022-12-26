import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n개배열
		Stack<Integer[]> stack = new Stack<>();
		int[] arr = new int[n]; // 정답이 될 배열
		Arrays.fill(arr, -1); // -1로 채움
		for (int i = 0; i < n; i++) {
			int Ai = sc.nextInt();
			while (stack.size() > 0 && stack.peek()[0] < Ai) {
				arr[stack.pop()[1]] = Ai;
			} // 현재 들어온애보다 작은애까지 pop하고 그 인덱스에 현재값 넣어줌
			stack.push(new Integer[] { Ai, i });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}
		System.out.println(sb.toString());
	}
}
