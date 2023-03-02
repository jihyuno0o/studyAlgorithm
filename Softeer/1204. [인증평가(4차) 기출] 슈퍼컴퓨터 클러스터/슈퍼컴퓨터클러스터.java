import java.util.Arrays;
import java.util.Scanner;

public class C1204_슈퍼컴퓨터클러스터 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long b = sc.nextLong();

        int[] computers = new int[n];
        for (int i = 0; i < n; i++) {
            computers[i] = sc.nextInt();

        }

        Arrays.sort(computers); // 오륾차순 정렬
        long left = computers[0]; // 최소값으로 초기화
        long right = computers[n - 1] + (long) Math.sqrt(b); // 최대값 + B원으로 최대 업그레이 할 수 있는 성능

        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (upgrade(computers, b, mid)) {
                left = mid + 1;
                answer = mid; // upgrade가 true이므로 mid까지는 업그레이 가능
            } else {
                right = mid - 1; // mid 값 만들 비용이 안됨
            }
        }

        System.out.println(answer);
    }

    public static boolean upgrade(int[] arr, long b, long min) {
        long cost = 0; // min을 만들 비용 계산
        for (int com : arr) {
            if (com < min) { // 최소가 되야할 값보다 작은 수는 업그레이드 비용 계산해줌
                cost += (min - com) * (min - com);
                if (cost > b) return false;
            }
        }
        return true;
    }


}
