import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        int[][] wv = new int[n][2];
        for (int i = 0; i < n; i++) {
            wv[i][0] = sc.nextInt();
            wv[i][1] = sc.nextInt();
        } // 입력

        for (int i = 1; i < n + 1; i++) { // n번째 아이템까지 고르고
            for (int j = 0; j < k + 1; j++) { // k무게까지 돌려보기
                if (wv[i - 1][0] > j) { // j보다 무거우면 안들어감
                    dp[i][j] = dp[i - 1][j];
                } else if (wv[i - 1][0] <= j) { // 가벼우면 합산무게 max
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wv[i - 1][0]] + wv[i - 1][1]);
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
