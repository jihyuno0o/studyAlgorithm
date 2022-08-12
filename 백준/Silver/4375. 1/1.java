import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			int target = Integer.parseInt(input);
			if (target == 1) {
				System.out.println(1);
				continue;
			}

			int n = 1;
			int cnt = 1;
			while (true) {
				n = (int) (n * 10 + 1) % target;
				cnt++;
				if (n % target == 0) {
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}
