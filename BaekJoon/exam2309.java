import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2309 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 9;
		int[] n = new int[cnt];
		int sum = 0; // ÀüÃ¼ ÇÕ
		
		for(int i=0; i<cnt; i++) {
			n[i] = Integer.parseInt(br.readLine());
			sum += n[i];
		}
		
		outer : for(int i=0; i<cnt; i++) {
			for (int j=i+1; j<cnt; j++) {
				if(sum - n[i] - n[j] == 100) {
					n[i] = 0; 
					n[j] = 0;
					break outer;
				}
			}
		}
		
		Arrays.sort(n);
		for(int i=2; i<cnt; i++) {
			System.out.println(n[i]);
		}
	}
}
