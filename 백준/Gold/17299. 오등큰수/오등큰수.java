import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//오등큰수
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] frequency = new int[1000001]; // 빈도수 저장
		int[] input = new int[n]; // 입력값 저장
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			frequency[input[i]]++;
		}

		int[] answer = new int[n]; // 정답 저장
		Arrays.fill(answer, -1);
		Stack<Integer[]> stack = new Stack<>();
		for (int i = 0; i < n; i++) { // 입력값 0번부터 n번까지
			while (stack.size() > 0 && stack.peek()[0] < frequency[input[i]]) { 
				answer[stack.pop()[1]] = input[i]; // 현재 빈도수가 스택의 앞선 숫자들의 빈도수보다 크면 
			}
			stack.push(new Integer[] { frequency[input[i]], i });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(answer[i]).append(' ');
		}

		System.out.println(sb.toString());
	}
}
