import java.util.Scanner;

// 2*n 타일링
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] f = new int[10001];
		f[1] = 1; // 2*1 일때
		f[2] = 2; // 2*2 일때

		System.out.println(fibo(f, n) % 10007);
	}

	public static int fibo(int[] f, int n) {
		if (f[n] != 0) {
			return f[n];
		} else {
			// | 와 = 가 앞에 온 경우로 나눠서 생각할 수 있다
			// | 가 앞에 온 경우 n-1의 경우의 수
			// = 가 앞에 온 경우 n-2의 경우의 수
			f[n] = fibo(f, n - 1) % 10007 + fibo(f, n - 2) % 10007;
			return f[n];
		}
	}
}
