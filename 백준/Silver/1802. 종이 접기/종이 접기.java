import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[] paper;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            String p = sc.next();
            int n = p.length();
            paper = new char[n];
            paper = p.toCharArray();

            if(check(0, n-1)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        } // test case

        System.out.println(sb.toString().trim());
    }

    public static boolean check( int start, int end) {
        if (start == end) { // 끝까지 탐색하면 true
            return true;
        }

        int mid = (start+end)/2; // 중간 값
        for(int i=start; i<mid; i++) {
            if(paper[i] == paper[end-i]) return false;
        }
        return check(start, mid-1) && check(mid+1, end); // 양쪽 동시 탐색

    }
}
