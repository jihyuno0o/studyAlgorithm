class Solution {
    public static int solution(String s) {
		int answer = s.length();
		String before = "";
		String after = "";
		for (int size = 1; size <= s.length() / 2; size++) {
			before = s.substring(0, size);
			int cursor = size;
			int temp = s.length();
			while (cursor <= s.length() - size) {
				after = s.substring(cursor, cursor+size);
				if(before.equals(after)) { // 같으면
					int cnt = 2; // 같은개 두개임
					while(cursor + size <= s.length() - size) { // 다음것도 같은지 확인
						cursor += size; // 커서옮기고
						after = s.substring(cursor, cursor+size);
						if(!before.equals(after)) { // 같지않으면 break
							break;
						}
						cnt++; // 같으면 while문 돌아
					}
					temp -= size*(cnt-1); // 압축한 문자열 길이빼주고
					temp += String.valueOf(cnt).length(); // 숫자 길이 더해줌
				}
				before = after;
				cursor += size;
			}
			
			if(temp < answer) {
				answer = temp;
			}
		}

		return answer;
	}
}