class Solution {
    static char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder(); // 자기차례 외칠 것만 저장
		StringBuilder number = new StringBuilder(); // 자기차례 끝날때까지 숫자 다 저장

		int turn = 0; // 외쳐야할 숫자
		for (int i = 0; i < t; i++) { // 자기 차례 몇번 ?
			while (m * i + p > number.length()) { // 자기 차례가 될때까지
				number.append(convert(n, turn++)); // 숫자들 number에 저장
			}
			answer.append(number.charAt(m * i + p - 1)); // 자기 차례에 외칠 숫자
		}

		return answer.toString();
	}

	public static String convert(int n, int num) {
		if (num == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder(); // 스트링빌더 생성
		while (num > 0) {
			sb.append(numbers[num % n]); // 진수 변경
			num /= n;
		}
		return sb.reverse().toString(); // 뒤집어야함
	}
}