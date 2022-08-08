package swea;

import java.util.Scanner;

public class p1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int N = sc.nextInt();
			int answer = 0;
			int[] building = new int[N];
			
			for (int i=0; i<N; i++) {
				building[i] = sc.nextInt();
			}
			
			for (int i=2; i<N-2; i++) {
				if (building[i] > building[i-2] && building[i] > building[i-1] && building[i] > building[i+1] && building[i] > building[i+2]) {
					int view = 255;
					if (building[i] > building[i-2]) {
						view = Math.min(view, building[i] - building[i-2]);
					}
					if (building[i] > building[i-1]) {
						view = Math.min(view, building[i] - building[i-1]);
					}
					if (building[i] > building[i+2]) {
						view = Math.min(view, building[i] - building[i+2]);
					}
					if (building[i] > building[i+1]) {
						view = Math.min(view, building[i] - building[i+1]);
					}
					answer += view;
				}
			}
			
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
