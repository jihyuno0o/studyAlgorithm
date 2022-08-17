import java.util.Scanner;
import java.util.Stack;

// 창고 다각형
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] height = new int[1001];
		int min = 1001, max = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			height[x] = y;
			min = Math.min(min, x); // 젤 작은 x값 찾기
			max = Math.max(max, x); // 젤 큰 x값 찾기
		}

		Stack<Integer> temp = new Stack<>();
		// 왼쪽 기준
		int curH = height[min]; // 현재높이
		for (int i = min + 1; i <= max; i++) {
			if (height[i] < curH) { // curH보다 작으면 x좌표 저장해놓고 패스
				temp.push(i);
			} else { // curH보다 높으면
				while (!temp.isEmpty()) { // 저장된 x좌표들 현재높이로 변경
					height[temp.pop()] = curH;
				}
				curH = height[i]; // curH 높여주기
			}
		}
		temp.clear();

		// 오른쪽 기준 (왼쪽 기준이랑 같음)
		curH = height[max];
		for (int i = max - 1; i >= min; i--) {
			if (height[i] < curH) { // curH보다 작으면 x좌표 저장해놓고 패스
				temp.push(i);
			} else { // curH보다 높으면
				while (!temp.isEmpty()) { // 저장된 x좌표들 현재높이로 변경
					height[temp.pop()] = curH;
				}
				curH = height[i]; // curH 높여주기
			}
		}

		int area = 0;
		for (int i = min; i <= max; i++) {
			area += height[i];
		}
		System.out.println(area);

	}
}
