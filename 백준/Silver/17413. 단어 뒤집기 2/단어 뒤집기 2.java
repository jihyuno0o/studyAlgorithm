import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String input = sc.nextLine();
		StringBuilder temp = new StringBuilder();
		int idx = 0;
		while (idx < input.length()) {
			switch (input.charAt(idx)) {
			case '<':
				sb.append(temp.reverse().toString());
				temp.setLength(0);
				sb.append('<');
				while (input.charAt(idx++) != '>') {
					sb.append(input.charAt(idx));
				}
				break;
			case ' ':
				sb.append(temp.reverse()).append(' ');
				temp.setLength(0);
				idx++;
				break;
			default:
				temp.append(input.charAt(idx++));
			}
		}
		System.out.println(sb.append(temp.reverse()).toString());
	}
}
