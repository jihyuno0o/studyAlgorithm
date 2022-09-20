import java.util.Scanner;

// N과 M (4) 중복조합
public class Main {
	static int[] num;
	static int[] sel;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = i+1;
		}
		sel = new int[M]; // 임시로 저장할 배열
		
		Combination(0, 0);
	}
	
	// idx : 해당 위치 숫자 뽑을지 말지
	// sidx : 뽑은 숫자의 위치
	public static void Combination(int idx, int sidx) {
		if(sidx == M) {
			for(int n : sel) {
				System.out.print(n);
				System.out.print(' ');
			}
			System.out.println();
			return;
		}
		else if(idx == N) return;
		sel[sidx] = num[idx]; // 일단 넣고
		Combination(idx, sidx+1); // idx숫자 다시뽑을 수 있음
		Combination(idx+1, sidx); // idx인덱스 숫자 선택 x
		
	}
}
