import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[1001][1001];
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		int maxX = 0;
		int maxY = 0;
		for(int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			
			if(x+w > maxX) maxX = x+w;
			if(y+h > maxY) maxY = y+h;
			
			for(int i=x; i<x+w; i++) {
				for (int j=y; j<y+h; j++) {
					map[i][j] = t;
				}
			}
		}
		
		for(int t=1; t<=T; t++) {
			int cnt = 0;
			for(int i=0; i<maxX; i++) {
				for (int j=0; j<maxY; j++) {
					if(map[i][j] == t) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
}
