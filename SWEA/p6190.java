package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6190 {
	public static boolean danjo(int num) {
		String n = num + "";
		for (int i = 0; i < n.length() - 1; i++) {
			if(n.charAt(i) > n.charAt(i + 1)) return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); 
			int max = -1;

			if (N == 1) { // N이 하나면 그 수만 단조증가 수인지 체크
				int num = Integer.parseInt(br.readLine()); 
				if (danjo(num)) {
					max = num;
				}
			} else {
				// A1, A2, ,,, 입력 받음
				int[] numbers = new int[N];
				StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
				
				for (int i = 0; i < N; i++) {
					numbers[i] = Integer.parseInt(stk.nextToken());
				}
				
				for(int i=N-1; i>=0; i--) {
					for(int j=N-2; j>=0; j--) {
						if(i != j) {
							int n = numbers[i]*numbers[j];
							if (danjo(n) && max<n) {
								max = n;
							}
						}
					}
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
}
