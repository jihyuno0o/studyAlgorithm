import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine().trim());
		for(int i=1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[][] out = new String[n][3];

			String[][] arr = new String[n][n];

			// input 받기
			for (int j=0; j<n; j++) {
				String[] input = br.readLine().split(" ");
				for (int k=0; k<n; k++) {
					arr[j][k] = input[k];
				}
			}
			
			//90도 돌리기
			for (int cnt=0; cnt<3; cnt++) {
				String[][] after = new String[n][n];			
				for (int j=n; j>0; j--) {
					for (int k=0; k<n; k++) {
						after[k][n-j] = arr[j-1][k];
					}
				}
				for( int j=0; j<n; j++)
					out[j][cnt] = String.join("", after[j]);
				
				arr = after;
			}
			
			System.out.printf("#%d\n",i);
			for( int j=0; j<n; j++) {
				System.out.println(String.join(" ", out[j]));
			}


		}
	}

//	public static String[][] turn(String[][] arr){
//		String[][] before = arr;
//		int n = arr.length;
//		String[][] after = new String[n][n];
//
//		for (int i=n; i>0; i--) {
//			for (int j=0; j<n; j++) {
//				after[j][n-i] =  before[i][j];
//			}
//		}
//
//		return after;
//	}
}
