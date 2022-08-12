import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] days  = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine().trim());
		
		for(int i=1; i<=t; i++) {
			String[] input = br.readLine().split(" ");
			int count = dayCount(input);
			System.out.printf("#%d %d\n", i, count);
		}
	}
	
	public static int dayCount(String[] input) {
		int m1 = Integer.parseInt(input[0]);
		int d1 = Integer.parseInt(input[1]);
		int m2 = Integer.parseInt(input[2]);
		int d2 = Integer.parseInt(input[3]);
		
		if(m1==m2) return d2-d1+1;
		else {
			int cnt = d2+1;
			for(int i=m1; i<m2; i++) {
				if(i==m1) cnt += days[i]-d1;
				else cnt += days[i]; 
			}
			return cnt;
		}				
	}
}
