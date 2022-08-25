import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 러시아 국기 같은 깃발
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine());
		int N, M;
		String[][] flag;
		int[][] count; // white, blue, red
		int[][] check;
		for (int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			count = new int[N][3]; // white, blue, red
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j) == 'W') count[i][0]++;
					else if(str.charAt(j) == 'B') count[i][1]++;
					else if(str.charAt(j) == 'R') count[i][2]++;
				}
			}// 입력
			
			check = new int[N][3];
			for(int i=0; i<N; i++) {
				check[i][0] += count[i][1] + count[i][2];
			}
			
			for(int i=0; i<N; i++) {
				check[i][1] += count[i][0] + count[i][2];
			}
			
			for(int i=0; i<N; i++) {
				check[i][2] += count[i][0] + count[i][1];
			}
			
			check[0][1] = 987654321; check[0][2] = 987654321;
			for(int i = 1; i<N; i++) {
				check[i][0] += check[i-1][0];
				check[i][1] += (check[i-1][0] <= check[i-1][1]) ? check[i-1][0] : check[i-1][1];
				check[i][2] += (check[i-1][1] <= check[i-1][2]) ? check[i-1][1] : check[i-1][2];
			}
			
			System.out.printf("#%d %d\n", t, check[N-1][2]);
		}// testcase
	}// main
}
