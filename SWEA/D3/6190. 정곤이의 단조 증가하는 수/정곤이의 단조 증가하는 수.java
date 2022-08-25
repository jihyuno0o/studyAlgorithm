import java.util.Scanner;

public class Solution {
	public static boolean monotoneIncreasing(int n) {
		String str = Integer.toString(n);
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) < str.charAt(i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int[] nums;
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			nums = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
						
			int max = monotoneIncreasing(nums[0]) ?  nums[0] : -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if (monotoneIncreasing(nums[i]*nums[j]) && max < nums[i]*nums[j]) {
						max = nums[i]*nums[j];
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		}
		
	}
}
