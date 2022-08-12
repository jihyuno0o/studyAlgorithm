import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) { // 테스트케이스 10개
			sc.nextInt(); // 테스트케이스 입력 날리기
			int[][] sum = new int[2][101]; // 각 줄 합 저장할 배열
			
			for(int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					int n = sc.nextInt();
					sum[0][i] += n; // 입력된 숫자의 행 sum+=n
					sum[1][j] += n; // 입력된 숫자의 열 sum+=n
					if (i==j) sum[0][100] += n; // 입력된 숫자가 오른쪽 아래로 떨어지는 대각선 숫자라면 sum+=n
					if ((i+j)==99) sum[1][100] += n; // 입력된 숫자가 왼쪽 아래로 떨어지는 대각선 숫자라면 sum+=n
				}
			}
			
			int max = -1; // 최대값 저장 변수
			for(int i=0; i<2; i++) { // sum 배열 돌기
				for (int j=0; j<101; j++) {
					if (sum[i][j] > max) max = sum[i][j]; // 가장 큰 값 찾기
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
