import java.util.Scanner;

// 별 찍기 - 10
public class Main {
	static char[][] stars;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		stars = new char[N][N];
		star(0, 0, N, false);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void star(int r, int c, int size, boolean block) {
		if (block) { // 빈칸일 때
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					stars[i][j] = ' ';
				}
			}
			return;
		}

		if (size == 1) { // 한칸 되면 별찍기
			stars[r][c] = '*';
			return;
		}

		/*
		 ***
		 * * 
		 ***
		 인 경우 9칸으로 쪼개서 보면 다섯번째 칸은 공백 
		 모든 큰 덩어리를 9칸로 쪼개서 보면 5번째 칸은 공백이다 
		 그리고 한칸이 1이 될 때, 별찍으면 됨
		 */
		int count = 0; // 5번째를 확인하는 변수
		int cut = size / 3; // 3등분 하는 수
		for (int i = r; i < r + size; i += cut) {
			for (int j = c; j < c + size; j += cut) {
				count++;
				if (count == 5) { // 빈칸일때
					star(i, j, cut, true);
				} else { // 빈칸이 아닐때
					star(i, j, cut, false);
				}
			}
		}

	}
}
