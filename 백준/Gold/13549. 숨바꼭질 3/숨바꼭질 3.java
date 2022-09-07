import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 3
public class Main {
	static int[] check = new int[100001];
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K)
			System.out.println(0); // 입력이 같을 때
		else {
			bfs();
			System.out.println(check[K]-1);
		}
	}

	public static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
        check[N] = 1;
		while (!que.isEmpty()) {
			int X = que.poll();
			if (X == K)
				break;
            
            if (X * 2 < check.length && check[X * 2] == 0) { // X*2
				que.add(X * 2);
				check[X * 2] = check[X]; // 0초후
			}
			if (X > 0 && check[X - 1] == 0) { // X-1
				que.add(X - 1);
				check[X - 1] = check[X] + 1; // 1초후
			}
			if (X + 1 < check.length && check[X + 1] == 0) { // X+1
				que.add(X + 1);
				check[X + 1] = check[X] + 1; // 1초후
			}
			

		}
	}
}
