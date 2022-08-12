import java.io.BufferedReader;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 3일차 - 회문1
class Solution {
	public static boolean palindrome(StringBuffer sb) {
		String str1 = sb.toString();
		String str2 = sb.reverse().toString();
		sb.reverse();
		if (str1.equals(str2))
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			Character[][] map = new Character[8][8]; // 8*8 배열 생성
			int ans = 0; // 찾은 회문의 개수
			int len = Integer.parseInt(br.readLine()); // 찾아야하는 회문의 길이
			// 입력받으면서 가로줄 회문 찾기
			for (int i = 0; i < 8; i++) { // 행 우선 순회
				StringBuffer rowSb = new StringBuffer(); // 가로줄 찾을 스트링버퍼
				String str = br.readLine(); // 한줄씩 읽기
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j);
					rowSb.append(map[i][j]); // 스트링버퍼에 더하기
					if (rowSb.length() > len) {
						rowSb.delete(0, 1); // len보다 길면 맨앞 문자 빼기
					}
					if (rowSb.length() == len && palindrome(rowSb)) { // 회문인지 확인
						ans++;
					}
				}
			}
			// 세로줄 회문 찾기
			for (int j = 0; j < 8; j++) { // 열 우선 순회
				StringBuffer colSb = new StringBuffer(); // 세로줄 찾을 스트링버퍼
				for (int i = 0; i < 8; i++) {
					colSb.append(map[i][j]); // 스트링버퍼에 더하기
					if (colSb.length() > len) {
						colSb.delete(0, 1); // len보다 길면 맨앞 문자 빼기
					}
					if (colSb.length() == len && palindrome(colSb)) { // 회문인지 확인
						ans++;
					}

				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
