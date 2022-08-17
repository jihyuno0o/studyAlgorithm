import java.util.Scanner;

// 참외밭
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fruit = sc.nextInt(); // 참외수
		int maxH = 0, maxW = 0, maxHI = 0, maxWI = 0;
		int[] length = new int[6];
		for (int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			length[i] = sc.nextInt();
			if ((d == 1 || d == 2) && maxW < length[i]) { // 가장 긴 가로의 길이와 위치 저장
				maxW = length[i];
				maxWI = i;
			} else if ((d == 3 || d == 4) && maxH < length[i]) { // 가장 긴 세로의 길이와 위치 저장
				maxH = length[i];
				maxHI = i;
			}
		}

		int smallW = 0, smallH = 0;
		if (maxWI - 1 < 0) {
			smallW = Math.abs(length[(maxWI + 1) % 6] - length[5]);
		} else {
			smallW = Math.abs(length[(maxWI + 1) % 6] - length[maxWI - 1]);
		} // 잘라낼 사각형의 가로
		if (maxHI - 1 < 0) {
			smallH = Math.abs(length[(maxHI + 1) % 6] - length[5]);
		} else {
			smallH = Math.abs(length[(maxHI + 1) % 6] - length[maxHI - 1]);
		} // 잘라낼 사각형의 세로

		System.out.println((maxW * maxH - smallW * smallH) * fruit);

	}
}
