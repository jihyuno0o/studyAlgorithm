import java.util.Scanner;

class Pos {
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] bingo = new int[7][7]; // 빙고판 저장
		Pos[] position = new Pos[26];
		
		for(int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				int n = sc.nextInt();
				bingo[i][j] = n; // 빙고판에 숫자 입력
				position[n] = new Pos(i,j); // 숫자의 위치 저장
			}
		}
		
		int bingoCnt = 0; 
		for (int i=1; i<=25; i++) { // 숫자 25개 부름
			int n = sc.nextInt(); // 심판이 부른 숫자
			int x = position[n].x;
			int y = position[n].y;
			
			if(++bingo[x][5] == 5) bingoCnt++; // 가로줄의 체크된 숫자 개수++
			if(++bingo[5][y] == 5) bingoCnt++; // 세로줄의 체크된 숫자 개수++
			if(x==y) {
				if(++bingo[5][5] == 5) bingoCnt++; // 오른쪽 아래로 떨어지는 대각선 줄 ++
			}
			if(x+y == 4) {
				if(++bingo[6][6] == 5) bingoCnt++; // 왼쪽 아래로 떨어지는 대각선 줄 ++
			}
			
			if(bingoCnt >= 3) { // 전부 채워진 줄이 3개가 넘으면 빙고
				System.out.println(i);
				break;
			}
		}
	}
}
