import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int middle = N/2; //0부터 시작할거라서 +1 안해줘도됨
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
//		Arrays.sort(nums);
//		System.out.println(nums[middle]);
		
		// sort 안쓰고 풀기
		int cnt = 0; // 젤 작은 수부터 찾기, 순서 저장할 변수
		while(true) {
			int min = 199; // 199가 가장 큰 수
			int idx = 0; // 젤 작은 수의 인덱스 
			for(int i=0; i<N; i++) {
				if (nums[i]<min) { // 젤 작은 수 찾기
					min = nums[i]; // 작은 수 저장
					idx = i; // 작은 수의 인덱스
				}
			} // 다 돌고나면 idx에는 가장 작은 수의 인덱스가 저장됨
			nums[idx] = 200; // 가장 작은 수가 있던 곳을 들어올 수 없는 큰 값으로 설정해줌
			if (cnt++ == middle) {
				System.out.println(min);
				break;
			}
		}
	}
}
