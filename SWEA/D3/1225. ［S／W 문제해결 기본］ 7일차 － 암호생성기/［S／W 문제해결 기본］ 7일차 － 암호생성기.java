import java.util.Scanner;

// [S/W 문제해결 기본] 7일차 - 암호생성기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums;

		for (int t = 1; t <= 10; t++) {
			sc.next();
			nums = new int[8];
			for (int i = 0; i < 8; i++) {
				nums[i] = sc.nextInt();
			} // 입력

			int minus = 1; // minus 해줄 값 
			int idx = 0; // 인덱스 순환용
			int zeroIdx = -1; // 0이 되는 자리를 기억
			while (true) {
				if (minus > 5) { // 5보다 크면 
					minus -= 5; // 5를 빼줘서 1로 만듬
				}
				nums[idx % 8] -= minus; // 해당 인덱스에 해당 minus 숫자 빼줌
				if (nums[idx % 8] <= 0) { // 0보다 작아지면
					nums[idx % 8] = 0; // 0으로 만들어주고
					zeroIdx = idx % 8; // 0인 인덱스 위치 기억
					break;
				}
				idx++;
				minus++;
			}
			
			System.out.print("#" + t);
			for(int i=zeroIdx+1; i<8; i++) { // 0 다음 인덱스 부터 출력
				System.out.printf(" %d", nums[i]);
			}
			for(int i=0; i<=zeroIdx; i++) { // 앞에서부터 0인 인덱스까지 출력
				System.out.printf(" %d", nums[i]);
			}
			System.out.println();
		}
	}
}
