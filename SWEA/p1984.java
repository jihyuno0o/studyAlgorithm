package swea;

import java.util.Scanner;

public class p1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int min = 10000; // 입력 들어올 수 있는 가장 큰 값
			int max = 0; // 가장 작은 값
			int sum = 0; // 숫자 합 저장 변수
			for (int i = 0; i < 10; i++) { // 10개 입력받음
				int n = sc.nextInt();
				min = Math.min(min, n); // 젤 작은 값 찾기
				max = Math.max(max, n); // 젤 큰 값 찾기
				sum += n; // 합 구하기
			}
			// 전체 합에서 max와 min뺀 숫자
			// 에 1.0 곱해줘서 소수점 한자리 double로 만들어준 후
			// 8로 나눔 그담에 반올림
			System.out.printf("#%d %d\n", t, Math.round(((sum - min - max) * 1.0) / 8));
		}
	}
}
