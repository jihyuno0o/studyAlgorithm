import java.util.*;

class Solution {
	public static String[] solution(String[] record) {
        Map<String, String> nickNames = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int changeCnt = 0;
        for(String str : record) {
        	switch(str.charAt(0)) {
        	case 'L':
        		break;
        	case 'C':
        		changeCnt++;
        	case 'E':
        		nickNames.put(str.split(" ")[1], str.split(" ")[2]);
        		break;
        	}
        }
        String[] answer = new String[record.length - changeCnt];
        int idx = 0;
        for(String str : record) {
        	switch(str.charAt(0)) {
        	case 'L':
        		answer[idx++] = nickNames.get(str.split(" ")[1]).concat("님이 나갔습니다.");
        		break;
            case 'E':
            	answer[idx++] = nickNames.get(str.split(" ")[1]).concat("님이 들어왔습니다.");
            	break;
            }
        }
        
        return  answer;
    }
}