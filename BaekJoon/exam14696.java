import java.util.Arrays;
import java.util.Scanner;

public class exam14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int t = 0; t < n; t++) {
			int aCnt = sc.nextInt();
			int[] aCards = new int[aCnt]; // a의 카드 저장
			for (int i = 0; i < aCnt; i++) {
				aCards[i] = sc.nextInt();
			}
			int bCnt = sc.nextInt();
			int[] bCards = new int[bCnt]; // b의 카드 저장
			for (int i = 0; i < bCnt; i++) {
				bCards[i] = sc.nextInt();
			}
			
			Arrays.sort(aCards);
			Arrays.sort(bCards);

			String winner = "D";
			while (aCnt > 0 && bCnt > 0) { //둘다 카드가 남았을 때
				if (aCards[--aCnt] > bCards[--bCnt]) { // 큰수부터 비교
					winner = "A";
					break;
				} else if (aCards[aCnt] < bCards[bCnt]) {
					winner = "B";
					break;
				}

				if (aCnt == 0 ^ bCnt == 0) { // 둘 중 하나가 0일 때
					winner = (aCnt > bCnt) ? "A" : "B";
				}
			}
			
			System.out.println(winner);
		}
	}
}
