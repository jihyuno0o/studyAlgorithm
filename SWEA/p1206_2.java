package swea;

import java.util.Scanner;

public class p1206_2 {
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
					answer += building[i] - Math.max(Math.max(building[i-2], building[i-1]), Math.max(building[i+1], building[i+2])); 
				}
			}
			
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
