import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int l = sc.nextInt();

		List<List<Integer>> list = new ArrayList<>();
		boolean[] visited = new boolean[n+1];
		
		for(int i = 0 ; i<= n ; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < l; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			list.get(x).add(y);
			list.get(y).add(x);

		}

		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		count++;
		while (!q.isEmpty()) {
			
			int x = q.poll();

			for (int i = 0; i < list.get(x).size(); i++) {
				
				if(visited[list.get(x).get(i)] == false) {
				q.add(list.get(x).get(i));
				
				visited[list.get(x).get(i)] = true;
				count++;
				}
			}

		}
		System.out.println(count-1);
	}

}