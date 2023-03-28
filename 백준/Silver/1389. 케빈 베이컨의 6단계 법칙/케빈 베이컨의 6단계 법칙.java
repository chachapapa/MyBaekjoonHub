import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {

			list.add(new ArrayList<>());

		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.get(start).add(end);
			list.get(end).add(start);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		
		int min = Integer.MAX_VALUE;
		int who = n+1;

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			int start = i;
			boolean[] visited = new boolean[n + 1];
			q.add(new int[] {start,0});
			visited[start] = true;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				sum += now[1];
				for(int x = 0 ; x<list.get(now[0]).size() ; x++) {
					
					if(visited[list.get(now[0]).get(x)] == false) {
						q.add(new int[] {list.get(now[0]).get(x), now[1]+1});
						visited[list.get(now[0]).get(x)] = true;
					}
					
					
				}
						
				
				
			}
			
			if(sum<min) {
				min = sum;
				who = i;
				
			}else if( sum == min && i<who) {
				who = i;
			}
		}
		
		System.out.println(who);
	}

}