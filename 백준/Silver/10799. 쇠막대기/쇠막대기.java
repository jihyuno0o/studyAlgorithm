import java.util.Scanner;

// 쇠막대기 자르기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = 0, cnt = 0;
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            }
            else {
                cnt--;
                if (str.charAt(i-1) == '(') {
                    sum += cnt;
                }
                else {
                    sum++;
                }
            }
        }
        System.out.println(sum);
	}
}
