import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(stk.nextToken());
		int h = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(br.readLine());

		p += t % (w * 2);
		q += t % (h * 2);
		if (p > w)
			p = Math.abs(w * 2 - p);
		if (q > h)
			q = Math.abs(h * 2 - q);
		System.out.println(p + " " + q);
	}
}
