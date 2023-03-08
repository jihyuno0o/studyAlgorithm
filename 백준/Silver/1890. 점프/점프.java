import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[][] dir = {{1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
            Arrays.fill(dp[i], -1);
        } // 입력


        System.out.println(go(0, 0));
    }

    public static long go(int r, int c) {
        if (r == N - 1 && c == N - 1) {
            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;
        int move = map[r][c];
        int nextRight = c + move;
        int nextBottom = r + move;

        if(nextRight < N) {
            dp[r][c] += go(r, nextRight);
        }

        if(nextBottom < N) {
            dp[r][c] += go(nextBottom, c);
        }

        return dp[r][c];
    }

}
