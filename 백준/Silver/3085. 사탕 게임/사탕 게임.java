import java.util.Scanner;

// 사탕 게임
public class Main {
	static int N;
	static char[][] candy;
	public static void swap(int x1, int y1, int x2, int y2) {
		char temp = candy[x1][y1];
		candy[x1][y1] = candy[x2][y2];
		candy[x2][y2] = temp;
	}
	
	public static int maxCount() {
		int rowCnt = 1, colCnt = 1, max = 1;
		// 열 체크
		for(int i=0; i<N; i++) {
			for (int j=0; j<N-1; j++) {
				if (candy[i][j] == candy[i][j+1]) {
					rowCnt++;
				} else rowCnt = 1;
				if (rowCnt == N) return N;
				if (max < rowCnt) max = rowCnt;
				
			}
			rowCnt = 1;
		}
		// 행 체크
		for(int j=0; j<N; j++) {
			for (int i=0; i<N-1; i++) {
				if (candy[i][j] == candy[i+1][j]) {
					colCnt++;
				} else colCnt = 1;
				if (colCnt == N) return N;
				if (max < colCnt) max = colCnt;
			}
			colCnt = 1;
		}
		return Math.max(max, Math.max(rowCnt, colCnt));
		
	}
	public static int solution() {
		int ans = 0;
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (j+1 < N) {
					swap(i,j,i,j+1);
					ans = Math.max(ans, maxCount());
					if (ans == N) return N;
					swap(i,j,i,j+1);
				}
				
				if (i+1 < N) {
					swap(i,j,i+1,j);
					ans = Math.max(ans, maxCount());
					if (ans == N) return N;
					swap(i,j,i+1,j);
				}
 			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		candy = new char[N][N];
		for(int i=0; i<N; i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				candy[i][j] = temp.charAt(j);
			}
		}
		
		System.out.println(solution());
		
	}
}
