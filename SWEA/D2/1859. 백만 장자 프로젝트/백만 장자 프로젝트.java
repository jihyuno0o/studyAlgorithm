import java.util.Scanner;

// 백만 장자 프로젝트
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		long money;
		Integer[] nums;
		
		for (int t = 1; t <= T; t++) {
			money = 0;
			N = sc.nextInt();
			nums = new Integer[N]; // 1일차부터 N일차 까지 예상
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			} // 입력
			
		int sell = nums[N-1]; // 뒤에서부터
		for (int i=N-2; i>=0; i--) {
			if(sell <= nums[i]) { // 현재 값보다 크면 그 값이 파는 값
				sell = nums[i];
			}
			else { // 현재값 보다 작으면
				money += sell - nums[i]; // 이득봄
			}
		}
			System.out.printf("#%d %d\n", t, money);
		} // testcase
	}
}
