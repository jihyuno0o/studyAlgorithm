import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int[] list = new int[Integer.parseInt(br.readLine())];
			stk = new StringTokenizer(br.readLine(), " ");
			int idx = 0;
			while (stk.hasMoreTokens()) {
				list[idx++] = Integer.parseInt(stk.nextToken());
			}

//			Arrays.sort(list);

			// 버블 정렬
//			for (int i = list.length-1 ; i>0; i--) {
//				for (int j = 0; j < i; j++) { // i 이후는 정렬 완료
//					if (list[j] > list[j + 1]) { // 이전 인덱스의 숫자가 다음 인덱스의 숫자보다 클 때
//						int temp = list[j];
//						list[j] = list[j + 1];
//						list[j + 1] = temp; // 자리바꿔주기
//					}
//				}
//			}

			// 선택 정렬
//			for (int i = 0; i < list.length - 1; i++) {
//				int minIdx = i; // i 이전은 정렬 완료
//				for (int j = i + 1; j < list.length; j++) {
//					if (list[minIdx] > list[j]) {
//						minIdx = j; // 제일 작은 값의 인덱스를 찾기
//					}
//				}
//				int temp = list[i];
//				list[i] = list[minIdx];
//				list[minIdx] = temp; // 현재 i 인덱스와 제일 작은 값 자리 바꿔주기
//			}
			
			// 삽입 정렬
			for(int i=1; i<list.length; i++) {
				int key = list[i]; // 자리를 찾아줄 숫자
				int j; // key가 들어갈 수 있는 위치
				for (j=i-1; j>=0 && key<list[j]; j--) {
					// i 이전 에서 key보다 큰 값들은 한칸씩 뒤로 밀어준다 (자리 확보)
					list[j+1] = list[j];
				}
				list[j+1] = key; // 마지막 루프가 돌면서 j-1 하고 나오므로 j+1 자리에 key를 넣어줌
			}
			System.out.print("#" + t);
			for (int n : list) {
				System.out.print(" " + n);
			}
			System.out.println();
		}
	}
}
