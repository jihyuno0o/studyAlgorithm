import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if (t%10 != 0) {
			System.out.println(-1);
		} else {
			int m = t/60;
			int s = t%60;
			System.out.printf("%d %d %d", m/5, m%5, s/10);
		}	
	}
}
