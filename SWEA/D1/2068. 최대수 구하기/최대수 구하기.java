import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int max = 0; // 최대값 저장
			for(int i=0; i<10; i++) { // 10개 입력
				max = Math.max(max, sc.nextInt()); // 입력받는수와 현재max값과 비교
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
