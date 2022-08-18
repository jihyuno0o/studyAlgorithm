import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// [S/W 문제해결 기본] 6일차 - 계산기3
class Solution {
	// 후위표기식으로 변경
	public static String change(String str) {
		Map<Character, Integer> isp = new HashMap<>();
		Map<Character, Integer> icp = new HashMap<>();
		isp.put('*', 2);
		isp.put('+', 1);
		isp.put('(', 0);
		icp.put('*', 2);
		icp.put('+', 1);
		icp.put('(', 3);

		Stack<Character> stack = new Stack<>();
		String output = "";

		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (curr == ')') { // 닫힌 괄호일때
				while (stack.peek() != '(') { // 열린괄호 나올때까지
					output += stack.pop();
				}
				stack.pop(); // ( 괄호 날리기
			} else if (icp.containsKey(curr)) { // 연산자일때
				if (stack.size() == 0 || icp.get(curr) > isp.get(stack.peek())) {
					stack.push(curr); // 스택이 비었거나, 들어오는 연산자의 우선순위가 더 클때 push
				} 
				else { // 들어오는 연산자의 순위가
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
			if (curr == '+' || curr == '*') { // 연산자일때
				int num2 = stack.pop();
				int num1 = stack.pop();

				switch (curr) {
				case '+':
					stack.push(num1 + num2);
					break;
				case '*':
					stack.push(num1 * num2);
					break;
				}
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
