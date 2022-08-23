import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 9일차 - 사칙연산
class Node {
	String data;
	int leftChild;
	int rightChild;
	
	public Node(String data) {
		this.data = data;
	}
}

public class Solution {
	static Node[] nodes;
	public static float calc(Node node) {
		if(node.leftChild != 0) { // 연산자
			float x = calc(nodes[node.leftChild]); // 숫자될때까지 계산
			float y = calc(nodes[node.rightChild]); // 숫자 될때까지 계산
			String operator = node.data; // 연산자
			
			return operation(operator, x, y);
		}
		return Integer.parseInt(node.data); // 자식 없으면 해당 노드가 숫자임
	}
	
	public static float operation(String op, float x, float y) {
		switch(op)  {
		case "+":
			return x+y;
		case "-":
			return x-y;
		case "*":
			return x*y;
		case "/":
			return x/y;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N;
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N+1];

			for(int i=0; i<N; i++) { // 트리 입력받기
				stk = new StringTokenizer(br.readLine(), " ");
				int nowNodeIdx = Integer.parseInt(stk.nextToken());
				nodes[nowNodeIdx] = new Node(stk.nextToken());
				
				if(stk.hasMoreElements()) { // 있으면 연산자이므로 무조건 좌우가 있음 
					nodes[nowNodeIdx].leftChild = Integer.parseInt(stk.nextToken());
					nodes[nowNodeIdx].rightChild = Integer.parseInt(stk.nextToken());
				}
			}
			
			System.out.printf("#%d %d\n", t, (int) calc(nodes[1]));
			
			
		}
	} // main
}
