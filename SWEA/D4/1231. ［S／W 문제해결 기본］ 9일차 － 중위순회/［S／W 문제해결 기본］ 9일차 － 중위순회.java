import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 9일차 - 중위순회
public class Solution {
	static int N;
	static String[] alpha;
	
	public static void inOrder(int idx) {
		if(idx*2 <= N) inOrder(idx*2); // 왼쪽자식 있으면 왼쪽자식 돌기
		System.out.print(alpha[idx]); // 본인
		if(idx*2+1 <= N) inOrder(idx*2+1); // 오른쪽자식 있으면 오른쪽 자식 돌기
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			alpha = new String[N+1]; // N까지 있는 배열로 생성
			
			for(int i=0; i<N; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				alpha[Integer.parseInt(stk.nextToken())] = stk.nextToken(); // 인덱스에 스트링 넣기
				// 나머지 토큰은 그냥 버려
			}
			System.out.printf("#%d ", t);
			inOrder(1);
			System.out.println();
		}
	}
}
