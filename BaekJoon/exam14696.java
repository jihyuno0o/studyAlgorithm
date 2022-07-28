import java.util.Arrays;
import java.util.Scanner;

public class exam14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int t = 0; t < n; t++) {
			int aCnt = sc.nextInt();
			int[] aCards = new int[aCnt]; // a�� ī�� ����
			for (int i = 0; i < aCnt; i++) {
				aCards[i] = sc.nextInt();
			}
			int bCnt = sc.nextInt();
			int[] bCards = new int[bCnt]; // b�� ī�� ����
			for (int i = 0; i < bCnt; i++) {
				bCards[i] = sc.nextInt();
			}
			
			Arrays.sort(aCards);
			Arrays.sort(bCards);

			String winner = "D";
			while (aCnt > 0 && bCnt > 0) { //�Ѵ� ī�尡 ������ ��
				if (aCards[--aCnt] > bCards[--bCnt]) { // ū������ ��
					winner = "A";
					break;
				} else if (aCards[aCnt] < bCards[bCnt]) {
					winner = "B";
					break;
				}

				if (aCnt == 0 ^ bCnt == 0) { // �� �� �ϳ��� 0�� ��
					winner = (aCnt > bCnt) ? "A" : "B";
				}
			}
			
			System.out.println(winner);
		}
	}
}
