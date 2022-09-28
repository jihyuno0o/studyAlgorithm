import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가르침
public class Main {
	static int N, K;
	static String[] strings;
	static boolean[] visited = new boolean[26]; // 알파벳
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) { // a,n,t,i,c
			System.out.println(0);
			return;
		} else if (K == 26) { // 모든 알파벳
			System.out.println(N);
			return;
		} else {
			strings = new String[N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				strings[i] = str.substring(4, str.length() - 4); // anti, tica 제거
			} // 입력

			visited['a' - 'a'] = true; // a,n,t,i,c 방문처리
			visited['n' - 'a'] = true;
			visited['t' - 'a'] = true;
			visited['i' - 'a'] = true;
			visited['c' - 'a'] = true;

			Combination(0, 0);
			System.out.println(ans);
		}
	}

	// idx : 해당 위치 숫자 뽑을지 말지
	// sidx : 뽑은 숫자의 위치
	public static void Combination(int idx, int sidx) {
		if (idx == K - 5) {
			int cnt = 0; // 해당 조합으로 읽을 수 있는 단어 개수
			for (int i = 0; i < N; i++) {
				boolean isPossible = true;
				for (int j = 0; j < strings[i].length(); j++) { // 단어 길이만큼
					if (!visited[strings[i].charAt(j) - 'a']) { // 조합에 없는 알파벳이면 못읽음
						isPossible = false;
						break;
					}
				}
				if (isPossible)
					cnt++;
			}
			if (ans < cnt) { // 최대값 갱신
				ans = cnt;
			}
			return;
		} else if (sidx == 26)
			return;

		if (!visited[sidx]) { // 방문처리 안되어 있으면 선택
			visited[sidx] = true; // 방문처리
			Combination(idx + 1, sidx + 1); // 고르고 넘어감
			visited[sidx] = false; // 돌아와서 지워줌
		}
		// 방문처리가 되어있으면 다음 알파벳 탐색하고
		// 돌아와서 지워주고나서 다음으로 돌아감
		Combination(idx, sidx + 1);

	}

}
