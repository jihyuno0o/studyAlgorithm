import java.util.Scanner;

// 치즈 도둑
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static int maxTaste, ans;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			cheese = new int[N][N];
			maxTaste = 0; // 100개까지 돌기 싫어서 젤 높은거 확인
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
					if(maxTaste < cheese[i][j]) {
						maxTaste = cheese[i][j]; 
					}
				}
			} // 입력
			
			ans = 1;
			for(int x=1; x<=maxTaste; x++) { // 1부터 확인
				int piece = 0; // 각각의 조각 개수 저장
				visited = new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] > x && !visited[i][j]) { // 그 날 보다 큰 숫자고 방문 안했을 때
							visited[i][j] = true; // 방문 처리하고
							pieceOfCheese(x, i, j); // 덩어리 찾기
							piece++; // 조각+1
						}
					}
				}
				ans = Math.max(piece, ans);
			}
			sb.append("#").append(t).append(' ').append(ans).append('\n');
			
		} // tc
		System.out.println(sb);
	}
	
	public static void pieceOfCheese(int t, int r, int c) {
		for(int i=0; i<4; i++) {
			int newDr = r + dr[i];
			int newDc = c + dc[i];
			if(!mapOk(newDr, newDc)) continue; // 범위체크
			if(!visited[newDr][newDc] && cheese[newDr][newDc] > t) {
				visited[newDr][newDc] = true;
				pieceOfCheese(t, newDr, newDc);
			}
		}
	}
	
	public static boolean mapOk(int r, int c) { // 범위체크
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}
}
