import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine().trim());
		
		for(int i=1; i<=t; i++) {
			String[] input = br.readLine().split(" ");
			int h1 = Integer.parseInt(input[0]);
			int m1 = Integer.parseInt(input[1]);
			int h2 = Integer.parseInt(input[2]);
			int m2 = Integer.parseInt(input[3]);
			
			int m = (m1+m2)%60;
			int h = (h1+h2+((m1+m2)/60))%12;
			if(h==0) h=12;
			
			System.out.printf("#%d %d %d\n",i,h,m);
		}
	}
}
