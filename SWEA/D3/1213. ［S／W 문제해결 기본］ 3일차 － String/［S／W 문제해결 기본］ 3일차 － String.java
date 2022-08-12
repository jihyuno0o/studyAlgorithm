import java.io.BufferedReader;
import java.io.InputStreamReader;

// [S/W 문제해결 기본] 3일차 - String
class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			br.readLine();
			String find = br.readLine();
			char[] inputString = br.readLine().toCharArray();
			
			int ans = 0;
			for(int i=0; i<inputString.length-find.length()+1; i++) {
				if(inputString[i] == find.charAt(0)) {
					int same = 1;
					for (int j=1; j<find.length(); j++) {
						if (inputString[i+j] != find.charAt(j)) {
							same = 0; 
							break;
						}
					}
					ans += same;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
