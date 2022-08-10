package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exam2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		int ans = 1;
		int plus = 1;
		int minus = 1;
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}

		for(int i=1; i<N; i++) {
			if (nums[i-1] == nums[i]) {
				plus++;
				minus++;
			} else if (nums[i-1] < nums[i]){
				plus++;
				minus = 1;
			} else {
				minus++;
				plus = 1;
			}
			ans = Math.max(ans, Math.max(plus, minus));
		}
		
		
		System.out.println(ans);
	}
}
