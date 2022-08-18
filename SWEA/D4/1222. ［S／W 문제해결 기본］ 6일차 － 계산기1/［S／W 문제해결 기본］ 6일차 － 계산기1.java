import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// [S/W 문제해결 기본] 6일차 - 계산기1
class Solution {
	// 후위표기식으로 변경
	public static String change(String str) {
		Map<Character, Integer> isp = new HashMap<>();
		Map<Character, Integer> icp = new HashMap<>();
		isp.put('+', 1); icp.put('+', 1);

		Stack<Character> stack = new Stack<>();
		String output = "";

		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (icp.containsKey(curr)) { // 연산자일때
				if (stack.size() == 0) {
					stack.push(curr); // 스택이 비었을때 
				} 
				else {
					while (!stack.isEmpty() && (isp.get(stack.peek()) >= icp.get(curr))) {
						output += stack.pop();
					}
					stack.push(curr);
				}
			} else { // 숫자일때
				output += str.charAt(i);
			}
		}
		while (stack.size() != 0) {
			output += stack.pop();
		}
		return output;
	}
	
	// 후위표기식 계산
	public static int calculator(String str) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (curr == '+')  { // 연산자일때
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1 + num2);
			}
			else { // 피연산자일때
				stack.push(Character.getNumericValue(curr));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			sc.next(); // 테스트케이스 길이 안씀
			String tc = sc.next();
			System.out.printf("#%d %d\n", t, calculator(change(tc)));
		}
	}
}
