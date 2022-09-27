import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// [모의 SW 역량테스트] 등산로 조성
class pos{
	int r;
	int c;
	
	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static List<pos> top;
	static int[] dr = {0, 0, -1, 1}; // 우좌상하
	static int[] dc = {1, -1, 0, 0};
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			int high = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] > high) {
						high = map[i][j];
					}
				}
			}// 입력
			
			// 봉우리 찾기
			top = findTop(high);
			
			
			// 봉우리 별로 가장 긴 길이 찾기
			ans = 0;
			for(int i=0; i<top.size(); i++) {
				visited[top.get(i).r][top.get(i).c] = true;
				trail(K, true, top.get(i), high, 1);
				visited[top.get(i).r][top.get(i).c] = false;
			}
			sb.append("#").append(t).append(' ').append(ans).append('\n'); 
			
		} // tc
		System.out.println(sb);
	}
	
	public static List<pos> findTop(int high) {
		List<pos> p = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(map[i][j] == high) {
					p.add(new pos(i,j));
				}
			}
		}
		return p;
	}
	
	public static void trail(int k, boolean flag, pos p, int height, int dist) {
		ans = Math.max(dist, ans); // 최대값 저장
		for(int i=0; i<4; i++) { // 4방향 조사 갈 수 있는지
			int newDr = p.r + dr[i];
			int newDc = p.c + dc[i];
			if(!mapOk(newDr, newDc)) { // 범위 벗어나는지 체크
				continue;
			}
			
			if(!visited[newDr][newDc] && map[newDr][newDc] < height) {
				visited[newDr][newDc] = true;
				trail(k, flag, new pos(newDr, newDc), map[newDr][newDc], dist+1);
				visited[newDr][newDc] = false;
			}
			else if(!visited[newDr][newDc] && flag && map[newDr][newDc]-k < height) {
				visited[newDr][newDc] = true;
				trail(k, false, new pos(newDr, newDc), height-1, dist+1);
				visited[newDr][newDc] = false;
			}
		}
		
	}
	
	public static boolean mapOk(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}
	
	
}