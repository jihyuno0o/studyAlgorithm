# [D3] [S/W 문제해결 기본] 3일차 - String - 1213 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi) 

### 성능 요약

메모리: 22,268 KB, 시간: 164 ms, 코드길이: 2,419 Bytes



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do


## 브루트포스
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 3일차 - String
class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			br.readLine(); // 테스트케이스 번호 그냥 넘기기
			String find = br.readLine(); // 찾을 문자열
			char[] inputString = br.readLine().toCharArray(); // 문장
			
			int ans = 0; // 찾은 문자열 개수
			for(int i=0; i<inputString.length-find.length()+1; i++) { // 0부터 총문자열-문자개수 까지 탐색
				if(inputString[i] == find.charAt(0)) { // 첫글자가 같으면
					int same = 1; 
					for (int j=1; j<find.length(); j++) { // 그다음 문자열까지 같은지 체크
						if (inputString[i+j] != find.charAt(j)) { // 다르면
							same = 0; // 같지않음
							break; // 나가기
						}
					}
					ans += same;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
```
