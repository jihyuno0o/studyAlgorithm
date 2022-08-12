import java.util.*;
public class Main {

	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	Queue<Integer> que= new LinkedList<Integer>();
	
	int n=sc.nextInt();
	for(int i=1; i<n+1; i++)
	{
		que.add(i);
	}
	int k=sc.nextInt();
	StringBuilder sb=new StringBuilder();
	sb.append("<");
	while(true)
	{
		if(que.isEmpty())
			break;
		for(int i=1; i<k; i++)
		{
			que.add(que.poll());
			
		}
		sb.append(que.poll());
		if(!que.isEmpty())
			sb.append(", ");
		
	}
	sb.append(">");
	System.out.println(sb.toString());
	
	}
}
