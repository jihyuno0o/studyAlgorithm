import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.next().trim().split("");
		LinkedList<String> editor = new LinkedList<>(Arrays.asList(input));

		ListIterator<String> iter = editor.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}

		int orderN = sc.nextInt();
		for (int i = 0; i < orderN; i++) {
			switch (sc.next()) {
			case "L":
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case "D":
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case "B":
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
					break;
				}
				break;
			case "P":
				String t = sc.next().trim();
				iter.add(t);
				break;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (String str : editor) {
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
}
