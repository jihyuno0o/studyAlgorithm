import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// [S/W 문제해결 응용] 3일차 - 공통조상
public class Solution {
	static int V, E, C1, C2;
	static int[] tree;
	
	public static List<Integer> findParent(int child) {
		List<Integer> parents = new ArrayList<Integer>();
		parents.add(child); // 본인부터 넣고 
		while(child != 0) { // root가 아니면
			child = tree[child]; // 부모찾고
			parents.add(child); // 넣기
		}
		Collections.reverse(parents); // 루트부터 순서되도록 뒤집기
		return parents;
	}
	
	static int count; // 서브트리 개수 세는 변수
	public static void countSubTree(int parent) {
		count++; // 본인도 +1
		for(int i=1; i<V+1; i++) { // 노드 수만큼
			if(tree[i] == parent) { // 인덱스 = 자신, 밸류 = 부모 이므로 자식을 찾았을 때
				countSubTree(i); // 해당 자식으로 재귀
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		List<Integer> aParent, bParent;
		int commonParent = -1;
		for(int t=1; t<=T; t++) {
			V = sc.nextInt(); // 정점의 총 수
			E = sc.nextInt(); // 간선의 총 수
			C1 = sc.nextInt(); // 조상을 찾는 정점
			C2 = sc.nextInt(); // 조상을 찾는 정점
			tree = new int[V+1]; // 정점의 수+1 만큼 배열 생성
			
			for(int i=0; i<E; i++) { // 간선의 수 만큼 반복
				int p = sc.nextInt(); // 앞에 나오는게 부모
				tree[sc.nextInt()] = p; // 자식 인덱스에 부모 넣기
			} // 입력
			
			aParent = findParent(C1);
			bParent = findParent(C2);
			int idx = 0;
			while(true) {
				if (aParent.get(idx).equals(bParent.get(idx))) {
					commonParent = aParent.get(idx++);
				}
				else {
					break;
				}
			}
			
			count = 0;
			countSubTree(commonParent);
			System.out.printf("#%d %d %d\n", t, commonParent, count);
		} // testcase
	} // main
}
