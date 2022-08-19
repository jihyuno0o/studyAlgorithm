import java.util.Scanner;

// 간단한 369게임
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		String num; // 1~N 까지 숫자 변수
		char temp; // 숫자를 자리별로 쪼개볼 변수
		int cnt = 0; // 3,6,9의 개수 세는 변수
		for (int i = 1; i <= N; i++) {
			num = Integer.toString(i);
			for (int j = 0; j < num.length(); j++) {
				temp = num.charAt(j);
				if ((int) temp % 3 == 0 && temp != '0') { // 각 자리가 3,6,9 라면
					cnt++;
				}
			}
			if (cnt > 0) { // 하나라도 3,6,9가 들어있으면
				while (cnt > 0) { // 개수만큼
					sb.append('-');
					cnt--;
				}
			} else { // 아니면 그냥 숫자
				sb.append(num);
			}

			sb.append(' ');
		}

		System.out.println(sb);

	}
}
