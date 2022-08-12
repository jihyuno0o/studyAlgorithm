import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int student = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		ArrayList<Integer> seq = new ArrayList<>();
		for(int s=1; s<=student; s++) {
			seq.add(Integer.parseInt(stk.nextToken()), Integer.valueOf(s));
		}
		
		
		for(int i=student-1; i>=0; i--) {
			System.out.printf("%d ", seq.get(i));
		}
	}
}
