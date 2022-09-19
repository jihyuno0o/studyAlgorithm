import java.util.Scanner;

// 하노이 탑 이동 순서
public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 메르센 수 2^n - 1
		sb.append((int) (Math.pow(2, N) -1)).append('\n');
		Hanoi(N, 1,2,3);
		
		System.out.println(sb);
		
	}
	
	public static void Hanoi(int N, int from, int by, int dest) {
		// 작은 탑이 완성 되면 return
		if(N==1) {
			sb.append(from).append(" ").append(dest).append('\n');
			return;
		}
		
		// 1 에서 3으로 옮겨야 할 때
		// N-1개를 2에 옮긴다
		Hanoi(N-1, from, dest, by);
		// N원반을 1에서 3으로 옮긴다
		sb.append(from).append(" ").append(dest).append('\n');
		// 다시 N-1개를 2에서 3으로 옮긴다
		Hanoi(N-1, by, from, dest);
	}
}
