import java.util.Scanner;

// 힙
public class Solution {
	static int[] heap;
	static int size;
	static StringBuilder output;

	public static void add(int n) {
		int idx = ++size; // 사이즈늘리고, 제일 뒷 번호로 idx지정
		heap[idx] = n; // 제일 뒤에 입력 값 넣기
		while (idx > 1) { // root 까지	
			if (n > heap[idx / 2]) { // 부모의 수보다 입력 값이 크면
				heap[idx] = heap[idx / 2]; // 현재 위치에 부모 값 넣기
				idx = idx / 2; // 현재 인덱스 부모의 인덱스로 바꿈
			} else {
				break;
			}
		}
		heap[idx] = n; // 계산된 위치에 입력값 넣기
	}

	public static void remove() {
		if (size < 1) { // 힙에 원소가 없을 때
			output.append("-1 ");
			return;
		}
		output.append(heap[1]);
		output.append(" ");
		// root를 output에 저장해주고
		int target = heap[size]; // 현재 제일 뒤에 있는 숫자를 저장
		heap[size--] = 0; // 제일 뒤의 자리 비워주기

		int idx = 1; // root에서부터 비교
		while (idx*2 <= size) { // root에서 젤마지막 원소까지 비교
			int smallIdx = (heap[idx * 2] > heap[idx * 2 + 1]) ? idx * 2 : idx * 2 + 1; // 해당 인덱스의 좌우 비교후 작은거 찾기
			if (target < heap[smallIdx]) { // 현재 target이 자식보다 작다면
				heap[idx] = heap[smallIdx]; // 자식을 현재 위치로 올려줌
				idx = smallIdx; // 자식 인덱스를 탐색 인덱스로 변경
			} else {
				break;
			}
		}
		heap[idx] = target; // 계산된 위치에 target 넣기
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 수행해야할 연산의 수
			heap = new int[N+1]; // N사이즈의 배열 생성
			size = 0; // 힙 사이즈 초기화
			output = new StringBuilder(); // output 초기화

			for (int i = 0; i < N; i++) {
				switch (sc.nextInt()) {
				case 1:
					// 삽입
					add(sc.nextInt());
					break;
				case 2:
					remove();
					break;
				}
				

			}
			System.out.printf("#%d %s\n", t, output);
		}
	}
}
