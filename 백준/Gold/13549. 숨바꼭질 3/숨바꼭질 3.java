import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 3
class Loc {
	int pos;
	int time;

	public Loc(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}

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
		}
	}

	public static void bfs() {
		Queue<Loc> que = new LinkedList<>();
		que.add(new Loc(N, 0));

		while (!que.isEmpty()) {
			Loc X = que.poll();
			if (X.pos == K) {
				System.out.println(X.time);
				break;
			}

			if (X.pos * 2 < check.length && check[X.pos * 2] == 0) { // X*2
				que.add(new Loc(X.pos * 2, X.time));
				check[X.pos * 2]++; // 0초후
			}
			if (X.pos > 0 && check[X.pos - 1] == 0) { // X-1
				que.add(new Loc(X.pos - 1, X.time + 1));
				check[X.pos - 1]++; // 1초후
			}
			if (X.pos + 1 < check.length && check[X.pos + 1] == 0) { // X+1
				que.add(new Loc(X.pos + 1, X.time + 1));
				check[X.pos + 1]++; // 1초후
			}

		}
	}
}
