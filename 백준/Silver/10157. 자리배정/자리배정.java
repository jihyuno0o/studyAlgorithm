import java.util.Scanner;

public class Main {
	static int[] dx = {0,1,0,-1}; // 우, 하 , 좌, 상 순서
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int I = sc.nextInt();
		int J = sc.nextInt();
		int K = sc.nextInt();
		
		if(K > I*J) { // 범위 벗어나면 0
			System.out.println(0);
			return;
		}
		
		int[][] seats = new int[I][J];
		
		int x =0, y=0, dir=0;
		for(int i=1; i<=I*J; i++) {
			if (i==K) {
				System.out.printf("%d %d", x+1, y+1); // 자리 찾으면 현재 위치 프린트 1부터 시작이라 +1해서 출력
				break;
			}
			seats[x][y] = i;
			if(x+dx[dir] >= I || x+dx[dir] < 0 || y + dy[dir] >= J || y + dy[dir] < 0 || seats[x + dx[dir]][y+dy[dir]] != 0) {
				//배열 벗어나는지 확인, // 자리가 비었는지 확인
				dir = (dir+1) % 4; // 그렇다면 방향 전환
			}
			x += dx[dir];
			y += dy[dir];
		}
	}
}
