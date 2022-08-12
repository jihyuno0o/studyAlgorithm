import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cards = new int[N];
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		Arrays.sort(cards);
		
		int diff = 3000000;
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int temp = cards[i]+cards[j]+cards[k];
					if(temp > M)
						break;
					if(diff > (M-temp)) {
						diff = M-temp;
						ans = temp;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
