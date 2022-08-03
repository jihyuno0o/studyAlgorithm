package baekjoon;

import java.util.Scanner;

public class exam14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] T = new int[n];
		int[] P = new int[n];
		int[] DP = new int[n+1];
		for(int i=0; i<n; i++) {
			T[i] = sc.nextInt();
			int p = sc.nextInt();
			P[i] = p;
			DP[i] = p;
		}
		
		for(int i=n-1; i>=0; i--) {
			if (i+T[i] > n) {
				DP[i] = DP[i+1];
			} else {
				DP[i] = Math.max(DP[i+1], DP[i]+DP[i+T[i]]);
			}
		}
		
		System.out.println(DP[0]);
	}
}
