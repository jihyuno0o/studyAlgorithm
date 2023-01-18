import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int five = 0; // 5의배수, 2*5 배수 세야하는데 5가 더 적게나오니까 5만 세도 됨
		for (int i = 2; i <= n; i++) {
			int temp = i;
			while (temp % 5 == 0) {
				five++;
				temp /= 5;
			}
		}
		System.out.println(five);
	}

}
