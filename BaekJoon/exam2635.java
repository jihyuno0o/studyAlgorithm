import java.util.ArrayList;
import java.util.Scanner;

public class exam2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ArrayList<Integer> ans = new ArrayList<>();
		int maxCnt = 0;
		for (int a = n; a >= n / 2; a--) {
			ArrayList<Integer> numbers = new ArrayList<>();
			numbers.add(n);
			numbers.add(a);
			int n1 = n;
			int n2 = a;
			
			while (true) {
				int next = n1-n2;
				if (next < 0)
					break;
				numbers.add(next);
				n1 = n2;
				n2 = next;
			}
			if (maxCnt < numbers.size()) {
				ans = numbers;
				maxCnt = numbers.size();
			}
		}

		System.out.println(maxCnt);
		for (Integer num : ans) {
			System.out.print(num + " ");
		}
	}
}
