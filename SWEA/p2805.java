package com.ssafy.swea.d3;

import java.util.Scanner;

public class p2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i=0; i<n; i++) {
				String str = sc.next();
				int[] line = new int[n];
				for (int j=0; j<n; j++) {
					line[j] = str.charAt(j)-'0';
				}
				map[i] = line;
			}
			
			int ans = 0;
			int start = n/2;
			int end = n/2;
			for (int i=0; i<n; i++) {
				for (int j=start; j<=end; j++) {
					ans += map[i][j];
				}
				if (i < n/2) {
					start -= 1;
					end += 1;
				} else {
					start += 1;
					end -= 1;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
