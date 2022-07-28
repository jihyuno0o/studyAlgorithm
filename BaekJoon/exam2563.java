import java.util.Scanner;

public class exam2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		final int MAX_VALUE = 101;
		int[][] map = new int[MAX_VALUE][MAX_VALUE];
		int paper = 10; // 색종이 변 길이
		int maxX = 0; 
		int maxY = 0;
		int ans = 0; // 검은 영역의 넓이
		
		for(int t=0; t<n; t++) {
			int x = sc.nextInt(), y = sc.nextInt();
			if (x > maxX) maxX = x;
			if (y > maxY) maxY = y;
			
			for(int i=x; i<x+paper; i++) {
				for (int j=y; j<y+paper; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<=maxX+paper; i++) {
			for (int j=0; j<=maxY+paper; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}

}
