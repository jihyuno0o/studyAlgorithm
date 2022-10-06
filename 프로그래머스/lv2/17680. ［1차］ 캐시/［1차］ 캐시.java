import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
			return 5 * cities.length;
		}
		int ans = 0;
		LinkedList<String> cache = new LinkedList<>(); // 맨뒤가 최근
		for(int i=0; i<cities.length; i++) {
			String city = cities[i].toUpperCase();
			// 캐시에 있으면
			if(cache.remove(city)) {
				ans += 1;
				cache.addLast(city);
			} 
			// 없으면
			else {
				ans += 5;
				cache.addLast(city); // 젤뒤에 넣고
				if(cache.size() > cacheSize) {
					cache.removeFirst(); // 맨앞에거 지우기
				}
			}
		}
		return ans;
    }
}