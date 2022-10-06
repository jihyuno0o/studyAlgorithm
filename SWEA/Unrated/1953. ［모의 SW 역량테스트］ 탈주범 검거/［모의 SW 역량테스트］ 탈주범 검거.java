import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 탈주범 검거
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] Ltime;
	static boolean[][] pipe = {
			{false, false, false, false},
			{true, true, true, true},
			{true, true, false, false},
			{false, false, true, true},
			{true, false, false, true},
			{false, true, false, true},
			{false, true, true, false},
			{true, false, true, false}
	}; // 0123 상하좌우, 01234567 이동가능방향
	static int[][] dir = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}}; // 0123 상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());
			L = Integer.parseInt(stk.nextToken());
			map = new int[N][M];
			Ltime = new boolean[N][M];
			for(int i=0; i<N; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}//입력
			ans = 0;
			Ltime[R][C] = true;
			arrest();
			sb.append("#").append(t).append(' ').append(ans).append('\n');
		}//tc
		System.out.println(sb.toString());
	}//main
	
	public static void arrest() {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {R, C, 1}); // 도착R, C, 현재시간
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			if(curr[2] > L) { // 시간지나면 pass
				return;
			}
			ans++;
			int newDr, newDc, j;
			for(int i=0; i<4; i++) {
				newDr = curr[0] + dir[i][0];
				newDc = curr[1] + dir[i][1];
				if(mapOk(newDr, newDc)) {
					if(i == 0 || i == 2) { // 상하, 좌우 바꿔줌
						j = i+1;
					} 
					else {
						j = i-1;
					}
					if(pipe[map[curr[0]][curr[1]]][i] && pipe[map[newDr][newDc]][j] && !Ltime[newDr][newDc]) { // 현재위치에서 갈수있는지, 도착지점 갈수 있는지
						Ltime[newDr][newDc] = true;
						que.add(new int[] {newDr, newDc, curr[2]+1});
					}
				}
			}
		}
		
	}
	
	public static boolean mapOk(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) {
			return false;
		}
		return true;
	}
	
}
