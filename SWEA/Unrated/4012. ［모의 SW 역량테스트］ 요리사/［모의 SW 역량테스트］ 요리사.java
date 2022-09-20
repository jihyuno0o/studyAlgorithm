import java.util.Arrays;
import java.util.Scanner;

// [모의 SW 역량테스트] 요리사
public class Solution {
	static int N;
	static int[][] S; // 시너지
	static int[] selA; // A재료
	static int[] selB; // B재료
	static int ans; // 맛의 차이(최소가 돼야함)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			} // 입력
			
			selA = new int[N / 2]; // 선택한 식재료 반
			selB = new int[N / 2];
			ans = Integer.MAX_VALUE;
			Combination(0, 0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	public static void Combination(int idx, int sidx) {
		if (sidx == N / 2) {
			otherIngredient(); // 반대쪽 식재료 뽑기
//			System.out.println(Arrays.toString(selB));
			ans = Math.min(ans, Synergy());// 시너지 계산
			return;
		} else if (idx == N)
			return;

		selA[sidx] = idx; // 식재료 일단 넣고
		Combination(idx + 1, sidx + 1); // 그 식재료 뽑고
		Combination(idx + 1, sidx); // 그 식재료 안뽑고
	}

	public static void otherIngredient() {
		int Aidx = 0, Bidx = 0;
		for (int i = 0; i < N; i++) {
			if (Aidx == N / 2 || selA[Aidx] != i) {
				selB[Bidx++] = i;
			} else {
				Aidx++;
			}
			if (Bidx == N / 2)
				return; // B재료 꽉채우면 끝
		}
	}

	public static int Synergy() {
		int A = 0, B = 0;
		for (int i = 0; i < N / 2 - 1; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				A += S[selA[i]][selA[j]]; // Sij
				A += S[selA[j]][selA[i]]; // Sji
				B += S[selB[i]][selB[j]];
				B += S[selB[j]][selB[i]];
			}
		}
		return Math.abs(A - B);
	}

}
