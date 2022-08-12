import java.util.Scanner;

// 초심자의 회문 검사
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String str = sc.next();
			
			int result = 1;
			for(int i=0; i<str.length()/2+1; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) { // 맨앞과 맨뒤 비교 부터 한칸씩 땡겨서
					result = 0; // 다르면 0
					break;
				}
			}
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
