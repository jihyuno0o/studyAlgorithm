import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 캐이스 입력
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 단어퍼즐 사이즈 n
			int K = sc.nextInt(); // 단어 사이즈 k

			int ans = 0; // k단어가 들어갈 수 있는 자리
			int[] cntCol = new int[N]; // 열 자리 확인 배열
			for (int i = 0; i < N; i++) {
				int cntRow = 0; // 행 자리 확인 변수
				for (int j = 0; j < N; j++) {
					if (sc.nextInt() == 1) { // 자리가 있을 때
						
						if (++cntRow == K) // 자리가 딱 K자리 수 이면 정답++
							ans++;
						else if (cntRow == K+1)// K자리보다 커지면 아까 더했던 정답 다시 --
							ans--;
						
						if (++cntCol[j] == K) // 자리가 딱 K자리 수 이면 정답++
							ans++;
						else if(cntCol[j] == K+1) // K자리보다 커지면 아까 더했던 정답 다시 --
							ans--;
						
					} else { // 0이 들어오면 확인변수 다시 초기화
						cntRow = 0; 
						cntCol[j] = 0;
					}
				}
			} // 퍼즐 입력 for
			
			System.out.printf("#%d %d\n", t, ans);
		} // testcase for
	} // main
}
