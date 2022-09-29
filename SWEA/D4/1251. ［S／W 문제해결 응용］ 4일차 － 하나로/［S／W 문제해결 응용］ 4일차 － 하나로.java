import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//[S/W 문제해결 응용] 4일차 - 하나로
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static double E, ans;
    static int[] p;
    static int[][] islands;
    static double[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            // 입력
            N = sc.nextInt();
            islands = new int[N][2]; // x,y
            for (int i = 0; i < N; i++) { //x
                islands[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) { //y
            	islands[i][1] = sc.nextInt();
            }
            
            E = sc.nextDouble(); // 환경부담세율실수
            // 엣지 생성
            edges = new double[N * (N - 1) / 2][3]; // 시작, 끝, 터널길이
            int idx = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i + 1; j < N; j++) {
                    edges[idx][0] = i; // 시작
                    edges[idx][1] = j; // 끝
                    // (E * L^2)
                    edges[idx++][2] = E
                            * (Math.pow(islands[i][0] - islands[j][0], 2) + Math.pow(islands[i][1] - islands[j][1], 2));
                }
            }

            Arrays.sort(edges, new Comparator<double[]>() {
                // [2] 값으로 정렬
                @Override
                public int compare(double[] o1, double[] o2) {
                    if (o1[2] > o2[2]) return 1;
                    else if (o1[2] < o2[2]) return -1;
                    return 0;
                }
            });

            // kruskal 알고리즘
            p = new int[N];
            // 나 자신을 대표로 초기화
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }

            ans = 0;
            int pick = 0;
            for (int i = 0; i < edges.length; i++) {
                int px = findSet((int) edges[i][0]);
                int py = findSet((int) edges[i][1]);

                if (p[px] != p[py]) { // 부모 다르면
                    union(px, py);
                    ans += edges[i][2]; // 더해
                    pick++;
                }
                // 간선은 V-1를 뽑는 순간 멈춘다.
                if (pick == (N - 1)) {
                    break;
                }
            }
            sb.append("#").append(t).append(' ').append(Math.round(ans)).append('\n');
        }//tc
        System.out.println(sb);
    }

    private static int findSet(int x) {
        if (x != p[x]) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y) {
        p[findSet(y)] = findSet(x); // y부모가 x부모가 됨
    }
}