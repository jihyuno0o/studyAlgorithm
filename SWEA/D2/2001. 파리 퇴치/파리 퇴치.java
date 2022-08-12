import java.util.Scanner;

// 파리 퇴치
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 영역 N*N
			int M = sc.nextInt(); // 파리채 사이즈 M*M

			int[][] map = new int[N][N]; // N*N 배열 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력 for

			int start = 0; // 첫 파리채 값
			for(int i=0; i<M; i++) {
				for(int j=0; j<M; j++) {
					start += map[i][j];
				}
			}// (0,0)~(M,M)의 파리채로 잡을 수 있는 파리수 초기화

			int maxSum = start; // 파리채가 내려쳐서 죽일 수 있는 가장 큰 값, ans
			for(int i=0; i<N-M+1; i++) {
				int sum = start; // 오른쪽으로 한칸씩 이동할 때 사용할 sum
				for (int j=0; j<N-M; j++) {
					for (int k=0; k<M; k++) {
						sum+=map[i+k][j+M]; // 오른쪽으로 한칸 이동해서 파리채 영역으로 들어온 값 더해주고
						sum-=map[i+k][j]; // 이동해서 파리채 영역 밖으로 나가게 된 값 빼주고
					}
					maxSum = Math.max(maxSum, sum);
				}
				if (i < N-M) { // 마지막 i일때는 다음 칸 없으므로 그 전까지만
					for(int k=0; k<M; k++) {
						start+=map[i+M][k]; // 아래로 한칸 이동해서 파리채 영역으로 들어온 값 더해주고
						start-=map[i][k]; // 이동해서 파리채 영역 밖으로 나가게 된 값 뺴주고
					}
				}
				maxSum = Math.max(maxSum, start);
			} // 파리채 이동 for

			System.out.printf("#%d %d\n", t, maxSum);
		} // testcase for
	}
}
