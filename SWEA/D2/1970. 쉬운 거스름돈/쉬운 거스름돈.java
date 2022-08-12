import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());

		int[] n =new int[t];
		for(int i=0; i<t; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<t; i++) {
			System.out.println("#"+(i+1));
			moneyCheck(n[i]);
		}
	}
	
	public static void moneyCheck(int n) {
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<money.length; i++) {		
			int cnt = n/money[i];
			n -= cnt*money[i];
			sb.append(cnt + " ");
		}
		System.out.println(sb);
	}
}
