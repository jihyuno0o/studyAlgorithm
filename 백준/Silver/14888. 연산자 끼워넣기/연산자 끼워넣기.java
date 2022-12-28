import java.util.Scanner;

// 연산자 끼워넣기
public class Main {
	static int n; // 수의 개수
	static int[] numbers; // 수 배열
	static int[] operators; // 연산자 넣을거 +(0), -(1), x(2), %(3)
	static int[] selOperators; // 순열로 뽑을거
	static boolean[] visited;
	static int max = -Integer.MAX_VALUE; // 최대값
	static int min = Integer.MAX_VALUE; // 최소값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		} // 수 입력받음

		operators = new int[n - 1];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt(); // 해당 연산자 개수
			if (cnt != 0) { // 0개가 아니면
				for (int j = 0; j < cnt; j++) {
					operators[idx++] = i;
				}
			}
		} // 연산자 개수 입력받아서 operators 에 넣음 {+, +, -, *, *, %} 처럼

		selOperators = new int[n - 1];
		visited = new boolean[n - 1];
		permutaion(0);
		System.out.println(max);
		System.out.println(min);

	}

	public static void permutaion(int idx) {
		if (idx == n - 1) {
			int result = calculator(numbers[0]);
			if (result > max) {
				max = result;
			}
			if (result < min) {
				min = result;
			}
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (!visited[i]) {
				visited[i] = true; // 이거 선택
				selOperators[idx] = operators[i];
				permutaion(idx + 1);
				visited[i] = false; // 선택 지우고 for 마저돌림
			}
		}
	}

	public static int calculator(int num) {
		for (int i = 0; i < n - 1; i++) {
			switch (selOperators[i]) {
			case 0: // +
				num += numbers[i + 1];
				break;
			case 1: // -
				num -= numbers[i + 1];
				break;
			case 2: // *
				num *= numbers[i + 1];
				break;
			case 3: // %
				num /= numbers[i + 1];
				break;
			}
		}
		return num;
	}
}
