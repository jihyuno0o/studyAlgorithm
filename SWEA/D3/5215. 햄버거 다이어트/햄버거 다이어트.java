import java.util.Scanner;

// 햄버거 다이어트
public class Solution {
	static int N, L;
	static int[] T, K;
	static int maxTaste;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t=1; t<=TC; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			T = new int[N];
			K = new int[N];
			for(int i=0; i<N; i++) {
				T[i] = sc.nextInt(); // 맛에 대한 점수
				K[i] = sc.nextInt(); // 재료 칼로리
			}// 입력
			maxTaste = 0;
			hamburger(0, 0, 0);
			System.out.printf("#%d %d\n", t, maxTaste);
		}
	}
	
	public static void hamburger(int idx, int taste, int kal) {
		if(kal > L) { // 칼로리 넘으면 체크할 필요 없음
			return;
		}
		else if(idx == N) {
			maxTaste = Math.max(maxTaste, taste);
			return;
		}
		hamburger(idx+1, taste, kal); // 재료 선택 안하고
		hamburger(idx+1, taste+T[idx], kal+K[idx]); // 재료 선택하고
		
	}
}
