import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine().trim());
		
		for(int i=1; i<=t; i++) {
			String[] input = br.readLine().split("");
			int num = pattern(input);
			System.out.printf("#%d %d\n",i,num);
			
		}
	}
	
	public static int pattern(String[] str) {
		String first = "";
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<30; i++) {			
			if(i==0) first=str[i];
			else if(str[i].equals(first)){
				int len = sb.length();
				int cnt = 0;
				StringBuffer nb = new StringBuffer();
				for(int j=0; j<len; j++) {
					nb.append(str[i+j]);
				}	
				if(sb.toString().equals(nb.toString())==true) return len;
			}
			sb.append(str[i]);
		}
		
		return -1;
	}
}
