import java.util.Scanner;

// 수열
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] nums = new int[N];
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		
		int maxSum = sum;
		for(int i=K; i<N; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
			sum -= nums[i-K];
			if (sum > maxSum) {
				maxSum = sum;
			}
		}

		System.out.println(maxSum);
	}
}
