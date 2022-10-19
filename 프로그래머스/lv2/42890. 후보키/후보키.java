import java.util.*;

class Solution {
    public static int solution(String[][] relation) {
    	int attribute = relation[0].length; // 속성개수
    	int N = relation.length; // 행 길이
    	List<Integer> key = new ArrayList<>(); // 후보키가 될 수 있는 것 저장
    	
    	int answer = 0;
    	select : for(int i=1; i< 1<<attribute; i++) { // powerset 으로 부분집합 찾기
    		//최소성 확인
    		for(int j=0; j<key.size(); j++) {
    			if((key.get(j)&i) >= key.get(j)) { // or 연산으로 이미 후보키인 것이 포함되어 있는지 확인
    				continue select;
    			}
    		}
    		
    		List<String> check = new ArrayList<>(); // 같은게 있는지 확인하는 리스트
    		for(int j=0; j<N; j++) { //행의개수만큼
    			String temp="";
    			for(int k=0; k<attribute; k++) { 
        			if((i & (1<<k)) > 0) { // 선택된 속성값을
        				temp = temp.concat(relation[j][k]); // 문자열로 넣어서 확인
        			}
        		}
    			
    			if(check.contains(temp)) { // 중복된게 있다면 넘어감
    				continue select;
    			}
    			check.add(temp); // 없으면 확인 리스트에 넣기
    		}
    		answer++; // 다 돌고 여기까지 왔다면 후보키 가능
    		key.add(i); // 후보키 리스트에 넣기
    	}
        return answer;
    }
}