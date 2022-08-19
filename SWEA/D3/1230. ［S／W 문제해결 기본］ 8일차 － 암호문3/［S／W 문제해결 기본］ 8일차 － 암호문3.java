import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		LinkedList<String> password = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			br.readLine(); // 원본 암호문의 길이
			stk = new StringTokenizer(br.readLine(), " ");// 원본 암호문
			while (stk.hasMoreTokens()) {
				password.add(stk.nextToken());
			}

			br.readLine(); // 명령어의 개수
			stk = new StringTokenizer(br.readLine(), " "); // 명령어
			int x, y;
			while (stk.hasMoreTokens()) {
				switch (stk.nextToken()) {
				case "I":
					// I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						password.add(x++, stk.nextToken());
					}
					break;
				case "D":
					// D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
					x = Integer.parseInt(stk.nextToken());
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						password.remove(x);
					}
					break;
				case "A":
					// A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다.
					y = Integer.parseInt(stk.nextToken());
					for (int i = 0; i < y; i++) {
						password.add(stk.nextToken());
					}
					break;
				}
			}

			System.out.print("#" + t);
			for (int i=0; i<10; i++) {
				System.out.print(" " + password.get(i));
			}
			System.out.println();
		}

	}

}
