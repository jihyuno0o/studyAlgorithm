import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	static Stack<Character> stack = new Stack<>();
	static Map<Character, Character> map = new HashMap<>();
	
	public static int findPair(String str) {
		for(int i=0; i<str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				stack.push(str.charAt(i));
			}
			else {
				if (map.get(stack.pop()) != str.charAt(i)) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			System.out.printf("#%d %d\n", t, findPair(sc.next()));
		}
	}
}
