import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int max = 100;
		int[][] map = new int[max][max];

		int maxX = 0;
		int maxY = 0;

		for (int square = 0; square < 4; square++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			if (x2 > maxX)
				maxX = x2;
			if (y2 > maxY)
				maxY = y2;
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);
	}
}
