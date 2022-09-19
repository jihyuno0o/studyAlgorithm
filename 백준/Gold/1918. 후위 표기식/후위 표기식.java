import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// 후위 표기식
public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		postfix(sc.next());
		System.out.println(sb);
	}
	
	public static void postfix(String str) {
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			if(curr == '(') { // 열린 괄호 일때
				stack.push(curr);
			}
			else if(curr == ')') { // 닫힌 괄호 일때
				while (stack.peek() != '(') { // 열린 괄호가 나올때까지
					sb.append(stack.pop());
				}
				stack.pop(); // 열린 괄호 날리기
			}
			else if(priority.containsKey(curr)) { // 연산자일때
				if(stack.size()==0 || priority.get(curr) > priority.get(stack.peek())) {
					// 스택이 비었거나, 현재 연산자가 스택의 연산자의 우선순위보다 클떄 push
					stack.push(curr);
				}
				else { // 현재 연산자가 스택의 연산자의 우선순위보다 작거나 같을때
					while(!stack.isEmpty() && (priority.get(curr) <= priority.get(stack.peek()))) {
						sb.append(stack.pop());
					}
					stack.push(curr);
				}
			}
			else { // 연산자가 아닐때
				sb.append(curr);
			}
		}
		// 남은 스택 비우기
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
