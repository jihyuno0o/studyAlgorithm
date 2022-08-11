package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 2일차 - Ladder1
public class p1210 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			br.readLine();
			int[][] map = new int[100][100];
			for(int i=99; i>=0; i--) { //사다리를 뒤집어서 2부터 시작해서 도착지점 찾기
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 사다리 입력
			
			int col = -1; // 2가 들어있는 시작지점
			for(int i=0; i<100; i++) {
				if (map[0][i] == 2) {
					col = i;
					break;
				}
			} // 시작지점 찾음
			
			int row = 0;
			while(row<99) {
				if(col - 1 >= 0 && map[row][col-1] == 1) {
					for(int i=col-1; i>=0; i--) {
						if(map[row+1][i] == 1) {
							col = i;
							break;
						}
					}
				} 
				else if(col + 1 < 100 && map[row][col+1] == 1) {
					for(int i=col+1; i<100; i++) {
						if (map[row+1][i] == 1) {
							col = i;
							break;
						}
					}
				}
				row++;
			}
			System.out.println(col);
		}
	}
}
