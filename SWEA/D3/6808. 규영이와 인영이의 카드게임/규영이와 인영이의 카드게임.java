import java.util.Arrays;
import java.util.Scanner;

// 규영이와 인영이의 카드게임
public class Solution {
	static int[] ky = new int[9];
	static int[] iy = new int[9];
	static int[] score;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			for(int i=0; i<9; i++) {
				ky[i] = sc.nextInt();
			}
			Arrays.sort(ky);
			makeIYCard(); // 인영이 카드 만들기
			score = new int[2]; // 0: 규영이가 이기는 경우, 1: 규영이가 지는 경우
			Permutation(0, 9, 9, iy); // 9개중에 9개 순열
			
			sb.append("#").append(t).append(' ');
			sb.append(score[0]).append(' ').append(score[1]).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void makeIYCard() { // 인영이 카드 만들기
		int kyIdx = 0;
		int iyIdx = 0;
		for(int i=1; i<=18; i++) {
			if(kyIdx == 9 || ky[kyIdx] != i) { // 규영이 카드에 없는 번호면
				iy[iyIdx++] = i; // 인영이 카드에 넣기
			} else{ // 규영이 카드에 있으면
				kyIdx++; // 규영이 다음 번호랑 비교
			}
			if(iyIdx == 9) return; // 인영이 카드 꽉차면 끝
		}
	}

	static int[] sel = new int[9];
	static boolean[] visited = new boolean[9];
	public static void Permutation(int idx, int N, int R, int[] arr) {
		if(idx == R) {
			countScore(ky, sel);
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) { // 중복인지 체크
				visited[i] = true;
				sel[idx] = iy[i];
				Permutation(idx+1, N, R, arr);
				visited[i] = false;
			}
		}
	}
	
	public static void countScore(int[] a, int[] b) {
		int aScore = 0, bScore = 0;
		for(int i=0; i<9; i++) {
			if(a[i] > b[i]) { // a카드 숫자가 크면
				aScore += a[i] + b[i];
			} else { // b카드 숫자가 크면
				bScore += a[i] + b[i];
			}
		}
		
		if(aScore > bScore) { // a총점이 크면
			score[0]++;
		}else if (aScore < bScore) { // b총점이 크면
			score[1]++;
		}
	}
}
