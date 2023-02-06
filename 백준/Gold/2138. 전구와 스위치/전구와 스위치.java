import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static char[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[] light1 = sc.next().toCharArray(); // 0번째 스위치 안눌렀을 때
        result = sc.next().toCharArray(); // 만들고자 하는 상태

        char[] light2 = light1.clone(); // 0번재 스위치 눌렀을 때
        light2[0] = light2[0] == '0' ? '1' : '0';
        light2[1] = light2[1] == '0' ? '1' : '0';

        solve(0, light1); // 0번째 안누른 상태로 돌려보고
        solve(1, light2); // 0번째 누른 상태로 돌려보고

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void solve(int cnt, char[] light) {
        for (int i = 1; i < n; i++) {
            if (light[i - 1] != result[i - 1]) {
                push(i, light);
                cnt++;
            }
            if (Arrays.equals(light, result)) {
                ans = Math.min(ans, cnt);
                return;
            }
        }
    }


    public static void push(int idx, char[] light) { // 스위치 누르는 함수
        light[idx - 1] = light[idx - 1] == '0' ? '1' : '0';
        light[idx] = light[idx] == '0' ? '1' : '0';
        if (idx < n - 1) {
            light[idx + 1] = light[idx + 1] == '0' ? '1' : '0';
        }
    }

}
