import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//숨바꼭질
public class Main {
	static int[] check = new int[100001];
	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) // 입력이 같을 때
			System.out.println(0);
		else {
			findK(N); // bfs
			System.out.println(check[K]); // 결과 출력
		}
	}

	public static void findK(int n) {
		Queue<Integer> que = new LinkedList<>(); // 큐 생성
		que.add(n);

		while (!que.isEmpty()) { // 큐가 빌때까지
			int X = que.poll(); // 현재 X

			if (X == K) // 값이 구해지면 스탑
				break;
			if (X > 0 && check[X - 1] == 0) { // X -1
				que.add(X - 1);
				check[X - 1] = check[X] + 1;
			}
			if (X + 1 < check.length && check[X + 1] == 0) { // X +1
				que.add(X + 1);
				check[X + 1] = check[X] + 1;
			}
			if (X * 2 < check.length && check[X * 2] == 0) { // X *2
				que.add(X * 2);
				check[X * 2] = check[X] + 1;
			}

		}
	}

}
