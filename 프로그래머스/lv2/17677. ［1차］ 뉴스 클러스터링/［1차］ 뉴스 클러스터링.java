import java.util.*;
import java.lang.*;

class Solution {
    
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase(); // 대문자로 통일
        str2 = str2.toUpperCase();
        List<String> strList1 = new ArrayList<>(); // 쪼갠 문자열 집합 넣을 리스트
        List<String> strList2 = new ArrayList<>();
        cutString(str1, strList1); // 쪼개기
        cutString(str2, strList2);
        
        if(strList1.size() == 0 && strList2.size() == 0) { // 둘다 공집합이면
            return 65536;
        }
        
        int intersec = 0;
        Collections.sort(strList1); // 정렬
        Collections.sort(strList2); // 정렬
        String[] strArr1 = strList1.toArray(new String[0]); // 배열로 바꿔줌
        String[] strArr2 = strList2.toArray(new String[0]);
        
        if(strArr1.length >= strArr2.length) { // 사이즈 큰거 비교
            intersec = cntIntersection(strArr2, strArr1);
        } else {
            intersec = cntIntersection(strArr1, strArr2);
        }
        double answer = (double) intersec / (double) (strArr1.length + strArr2.length - intersec);
        return (int) Math.floor(answer * 65536);
    }
    
    public static void cutString(String str, List<String> strList) {
        char[] temp = new char[2];
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i+1) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i+1) <= 'Z') {
                temp[0] = str.charAt(i);
                temp[1] = str.charAt(i+1);
                strList.add(String.valueOf(temp));
            }
        }
    }
    
    public static int cntIntersection(String[] str1, String[] str2) {
        int intersection = 0;
        boolean[] visit = new boolean[str1.length];
        for(int i=0; i<str2.length; i++) {
            for(int j=0; j<str1.length; j++) {
                if(!visit[j] && str1[j].equals(str2[i])) {
                    intersection++;
                    visit[j] = true;
                    break;            
                }
            }           
        }
        return intersection;
    }
}