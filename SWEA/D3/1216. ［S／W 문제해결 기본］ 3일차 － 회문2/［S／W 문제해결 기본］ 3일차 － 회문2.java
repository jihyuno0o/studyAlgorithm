import java.io.BufferedReader;
import java.io.InputStreamReader;

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
			br.readLine();
			StringBuffer[] colSb = new StringBuffer[100];
			for (int i = 0; i < 100; i++) {
				colSb[i] = new StringBuffer();
			}
			StringBuffer sb;

			int max = 0;
			for (int i = 0; i < 100; i++) { // 한줄 입력받고, 가로 확인
				String inputLine = br.readLine();

				for (int j = 0; j < 100; j++) { // 세로 확인용 sb에 저장
					colSb[j].append(inputLine.charAt(j));
				}

				check: for (int j = 100; j > max; j--) { // 체크할 글자수
					for (int k = 0; k <= 100 - j; k++) { // 글자수로 한줄에 몇번 체크할지 계산
						sb = new StringBuffer(inputLine.substring(k, k + j));
						if (palindrome(sb)) {
							max = j;
							break check; // 100부터 -- 했으니까 max찾으면 끝
						}
					}
				}
			} // 가로 for

			for (int i = 0; i < 100; i++) { // 세로 확인
				String colLine = colSb[i].toString();
				check: for (int j = 100; j > max; j--) { // 체크할 글자수
					for (int k = 0; k <= 100 - j; k++) { // 글자수로 한줄에 몇번 체크할지 계산
						sb = new StringBuffer(colLine.substring(k, k + j));
						if (palindrome(sb)) {
							max = Math.max(max, j);
							break check; // 100부터 -- 했으니까 max찾으면 끝
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}

	}
}