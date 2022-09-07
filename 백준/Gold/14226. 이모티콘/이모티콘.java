import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 이모티콘
class Emoticon {
	int screen; // 현재 화면의 이모티콘 개수
	int clipboard; // 복사한 클립보드의 이모티콘 개수
	int second; // 시간

	public Emoticon(int screen, int clipboard, int time) {
		this.screen = screen;
		this.clipboard = clipboard;
		this.second = time;
	}
}

public class Main {
	static int maxEmoCnt = 1001; // 화면이모티콘, 클리보드이모티콘
	static int S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();

		bfs();
	}

	public static void bfs() {
		boolean[][] visited = new boolean[maxEmoCnt][maxEmoCnt];
		Queue<Emoticon> queue = new LinkedList<>();
		queue.add(new Emoticon(1, 0, 0));
		visited[1][0] = true; // 0초에 방문했으니 방문처리
		
		while (!queue.isEmpty()) {
			Emoticon emo = queue.poll();
			int screenN = emo.screen;
			int clipboardN = emo.clipboard;
			int time = emo.second;

			if (screenN == S) { // 화면에 S개가 만들어지면
				System.out.println(time);
				break;
			}

			// 복사
			if (screenN > 0 && !visited[screenN][screenN]) {
				visited[screenN][clipboardN] = true;
				queue.add(new Emoticon(screenN, screenN, time + 1)); // screen에 있는 이모티콘을 clipboard에 복사
			}
			// 붙여넣기
			if (clipboardN > 0 && (screenN + clipboardN) < maxEmoCnt && !visited[screenN + clipboardN][clipboardN]) {
				visited[screenN + clipboardN][clipboardN] = true;
				queue.add(new Emoticon(screenN + clipboardN, clipboardN, time + 1)); // clipboard에 있는 이모티콘을 screen에 더해줌
			}
			// 삭제
			if (screenN > 0 && !visited[screenN - 1][clipboardN]) {
				visited[screenN - 1][clipboardN] = true;
				queue.add(new Emoticon(screenN - 1, clipboardN, time + 1));
			}
		}

	}
}
