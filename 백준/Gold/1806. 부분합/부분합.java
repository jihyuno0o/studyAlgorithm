import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int totalSum = 0;

        int[] arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            totalSum += arr[n];
        }
        if (totalSum < S) {
            System.out.println(0);
            return;
        }

        //투포인터로 구하기
        int s = 0;
        int e = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                ans = Math.min(e - s, ans);
            } else if (e == N) {
                break;
            }

            if (sum < S) {
                sum += arr[e++];
            } else {
                sum -= arr[s++];
            }
        }

        System.out.println(ans);

    }


}

