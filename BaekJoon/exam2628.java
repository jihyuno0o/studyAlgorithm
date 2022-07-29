import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class exam2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		List<Integer> w = new ArrayList<>();
		List<Integer> h = new ArrayList<>();
		w.add(0);
		h.add(0);

		int x = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			if (stk.nextToken().equals("0")) {
				w.add(Integer.parseInt(stk.nextToken()));
			} else {
				h.add(Integer.parseInt(stk.nextToken()));
			}
		}
		w.add(y);
		h.add(x);

		Collections.sort(w);
		Collections.sort(h);

		int maxX = 0;
		int maxY = 0;
		for (int i = 1; i < w.size(); i++) {
			if ((w.get(i) - w.get(i - 1)) > maxX) {
				maxX = w.get(i) - w.get(i - 1);
			}
		}
		for (int i = 1; i < h.size(); i++) {
			if ((h.get(i) - h.get(i - 1)) > maxY) {
				maxY = h.get(i) - h.get(i - 1);
			}
		}

		System.out.println(maxX * maxY);

	}
}
