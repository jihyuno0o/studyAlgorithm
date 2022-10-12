import java.util.*;

class Solution {

	public static String[] solution(String[] orders, int[] course) {
		Map<String, Integer> comb = new HashMap<>();
		for (String str : orders) {
			findComb(str, comb);
		}

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			int rank = 0;
			for (Map.Entry<String, Integer> map : comb.entrySet()) {
				if (map.getKey().length() == course[i] && map.getValue() > rank) {
					rank = map.getValue();
				}
			}
			if (rank < 2) { // 최소 2명 이상의 손님에게 주문 받은 구성만 포함
				continue;
			}
			for (Map.Entry<String, Integer> map : comb.entrySet()) {
				if (map.getKey().length() == course[i] && map.getValue() == rank) {
					answer.add(map.getKey());
				}
			}
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	public static void findComb(String s, Map<String, Integer> comb) {
		char[] temp = s.toCharArray();
		int N = temp.length;
		Arrays.sort(temp);
		for (int i = 1; i < 1 << N; i++) {
			String order = "";
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					order += temp[j];
				}
			}
			if (order.length() >= 2) {
				if (comb.containsKey(order)) {
					comb.put(order, comb.get(order) + 1);
				} else {
					comb.put(order, 1);
				}
			}
		}
	}
}