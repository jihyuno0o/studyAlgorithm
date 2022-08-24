import java.util.*;
public class Main {
	static int[][] point;
	static boolean visited[];
	static int N;
	static int M;
	static int V;
	
	public static void dfs(int i)
	{
		visited[i]=true;
		System.out.print(i+" ");
		for(int j=1; j<=N; j++)
		{
			if(point[i][j]==1 && visited[j]==false)
				dfs(j);
		}
	}
	
	public static void bfs()
	{
		Queue<Integer> que=new LinkedList<Integer>();
		que.offer(V);
		visited[V]=true;
		System.out.print(V+" ");
		
		int temp;
		while(!que.isEmpty())
		{
			temp=que.poll();
			for(int j=1; j<=N; j++)
			{
				if(point[temp][j]==1&&visited[j]==false)
				{
					que.offer(j);//j로 확인
					visited[j]=true;
					System.out.print(j+" ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		point=new int[1001][1001];
		visited=new boolean[1001];
		V=sc.nextInt();
		
		for(int i=0; i<M; i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			point[a][b]=point[b][a]=1;
		}
		dfs(V);
		visited=new boolean[1001];//초기화
		System.out.println();
		bfs();
		// TODO Auto-generated method stub

	}

}
