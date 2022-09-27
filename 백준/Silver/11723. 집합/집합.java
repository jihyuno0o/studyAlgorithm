import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 집합
public class Main {
	static ArrayList<Integer> set;
	
	static void add(int x) {
		set.add(x);
	}
	
	static void remove(int x) {
		if(set.contains(x)) {
			int idx = set.indexOf(x);
			set.remove(idx);
		}
	}
	
	static int check(int x) {
		if(set.contains(x)) {
			return 1;
		}
		return 0;
	}
	
	static void toggle(int x) {
		if(set.contains(x)) {
			int idx = set.indexOf(x);
			set.remove(idx);
		}
		else {
			set.add(x);
		}
	}
	
	static void all() {
		set.clear();
		for(int i=0; i<20; i++) {
			set.add(i, i+1);
		}
	}
	
	static void empty() {
		set.clear();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		set = new ArrayList<>();
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "add":
				add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				sb.append(check(Integer.parseInt(st.nextToken()))).append('\n');
				break;
			case "toggle":
				toggle(Integer.parseInt(st.nextToken()));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			} // switch
		} // M개 연산
		System.out.println(sb);
	} // main
}
