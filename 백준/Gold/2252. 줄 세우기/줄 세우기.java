import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		for (int test = 1; test <= 10; test++) {

			int v = sc.nextInt();
			int e = sc.nextInt();

			List<List<Integer>> list = new ArrayList<>();

			for (int i = 0; i < v + 1; i++) {

				list.add(new ArrayList<>());

			}

			int[] nodecount = new int[v+1];
			
			for (int i = 0; i < e; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				list.get(start).add(end);
				nodecount[end]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
//			boolean[] visited = new boolean[v+1];
			for(int i = 1 ; i < v+1 ; i++) {
				if(nodecount[i] == 0) {
					q.add(i);
//					visited[i] = true;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				
				int now = q.poll();
				sb.append(now).append(" ");
				
				for(int i = 0 ; i<list.get(now).size() ; i++) {
					nodecount[list.get(now).get(i)]--;
				}
				
				for(int i = 0 ; i<list.get(now).size() ; i++) {
					if( nodecount[list.get(now).get(i)] == 0) {
						q.add(list.get(now).get(i));
//						visited[list.get(now).get(i)] = true;
					}
				}
				
			}
			
			System.out.println(sb);
//		}

	}

}