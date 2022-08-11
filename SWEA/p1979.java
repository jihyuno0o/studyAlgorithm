package swea;
// 어디에 단어가 들어갈 수 있을까
import java.util.Scanner;

public class p1979 {
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
                    // 자리가 있을 때
                    if (sc.nextInt() == 1) { 
                        // 행 확인
                        if (++cntRow == K) ans++; // 자리가 딱 K자리 수 이면 정답++
                        else if (cntRow == K+1) ans--; // K자리보다 커지면 아까 더했던 정답 다시 --
                             
                        // 열 확인
                        if (++cntCol[j] == K) ans++; // 자리가 딱 K자리 수 이면 정답++
                        else if(cntCol[j] == K+1) ans--; // K자리보다 커지면 아까 더했던 정답 다시 --
                    } 
                    // 0이 들어오면 확인변수 다시 초기화
                    else {
                        cntRow = 0; 
                        cntCol[j] = 0;
                    }
                }
            } // 퍼즐 입력 for
			
			System.out.printf("#%d %d\n", t, ans);
		} // testcase for
	} // main
}
