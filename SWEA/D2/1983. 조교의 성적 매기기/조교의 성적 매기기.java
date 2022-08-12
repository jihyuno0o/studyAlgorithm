import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] score = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			String[] input1 = br.readLine().split(" ");
			int n = Integer.parseInt(input1[0]);
			int k = Integer.parseInt(input1[1]);
			
			ArrayList<Double> arr = new ArrayList<>();
			double check = 0.0;
			
			for(int j=1; j<=n; j++) {
				String[] input2 = br.readLine().split(" ");
				int mid = Integer.parseInt(input2[0]);
				int finl = Integer.parseInt(input2[1]);
				int task = Integer.parseInt(input2[2]);
				double total = mid*(0.35) + finl*(0.45) + task*(0.20);
				arr.add(total);
				if(j==k) check = total;
			}
			
			Collections.sort(arr);
			
			int index = 0;
			for(int j=0; j<arr.size(); j++) {
				if(arr.get(j)==check) index = j;
			}
			
			index = index/(n/10);
			System.out.printf("#%d %s\n", i, score[index]);
		}
	}
}
