package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int num = -1;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			switch (stk.nextToken()) {
			case ("push"):
				num = Integer.parseInt(stk.nextToken());
				queue.add(num);
				break;
			case ("pop"):
				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
				break;
			case ("size"):
				System.out.println(queue.size());
				break;
			case ("empty"):
				if (queue.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("front"):
				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
				break;
			case ("back"):
				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(num);
				}
				break;

			}
		}
	}
}
