import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] beforeCount = new int[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph.get(s).add(e);
			beforeCount[e]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		// 0인거먼저 줄세우기
		for(int i=1; i<n+1; i++) {
			if(beforeCount[i] == 0) {
				que.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(' ');
			
			// now와 인접한 애들 가져오기
			List<Integer> list = graph.get(now);
			
			for(int i=0; i<list.size(); i++) {
				// 인접한애들 진입차수 갱신
				if(--beforeCount[list.get(i)] == 0) {
					que.offer(list.get(i));
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
