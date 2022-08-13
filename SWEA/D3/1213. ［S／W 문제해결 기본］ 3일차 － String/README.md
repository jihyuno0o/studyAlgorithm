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

## 보이어무어
```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 0; tc < 10; tc++) {
            //1. 입력받기
            sc.next();
            String f = sc.next();
            String words = sc.next();
            
            //2. 보이어 무어
            int M = f.length();
            int N = words.length();
            Map <Character, Integer> skip = makeSkip(f); // skip 배열 생성
            
            int idx = M-1; // 시작 인덱스 타겟 글자크기의 젤 뒤부터 체크
            int sum = 0;
            while(idx<N) { // 인덱스가 찾아야할 word 길이와 같아질때까지
                boolean check = true; // 탐색 확인 변수
                for(int i=0; i<M; i++) { // 타겟 글자수 만큼
                    if(words.charAt(idx-i)!=f.charAt(M-i-1)) { // 뒤에서부터 체크 // 같지않으면
                        check = false; // false로 변경
                        if(!skip.containsKey(words.charAt(idx-i))) { // skip배열(타겟 단어)에서 일치하지 않은 word의 알파벳이 있는지 확인
                            idx += M-i; // 없으면 타겟 글자수만큼 인덱스 이동
                        }
                        else { // 타겟 글자안에 word의 알파벳이 있다면 value값 가져와서 해당 값만큼 인덱스 이동
                            if(skip.get(words.charAt(idx-i)) - i > 0) { // 이미 동일하다고 체크해서 지나간 단어가 나오면
                                idx += skip.get(words.charAt(idx-i)) - i; 
                            } else idx ++; // 그냥 인덱스 한칸 이동후 다시 탐색
                        }
                        break; // 같지 않고 인덱스 변경이 끝나면 탐색 중지
                    }
                }
                if(check) { // 탐색 중지 당하지 않고 word와 target 비교가 같으면 
                    sum ++; // 정답 +1
                    idx ++; // 다음 인덱스부터 다시 탐색
                }
            }
            System.out.printf("#%d %d\n", tc+1, sum);
            
        }
    }
    public static Map<Character, Integer> makeSkip(String f) { // skip 배열 만들기
        int M = f.length()-1;
        Map<Character, Integer> result = new HashMap<>();
        for(int i=0; i<f.length(); i++) {
            result.put(f.charAt(i), M--); // 해당 스트링 안에서 특정 알파벳의 위치를 저장 (젤 뒤가 0, 그 앞이 1, 2,,,,)
        }
        return result;
    }
}
```
