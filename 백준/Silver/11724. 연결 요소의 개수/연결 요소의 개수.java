import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

			// 노드 수
			int n = sc.nextInt();
			// 간선 수
			int m = sc.nextInt();

			List<List<Integer>> list = new ArrayList<>();
			boolean[] visited = new boolean[n + 1];

			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				list.get(x).add(y);
				list.get(y).add(x);

			}

			int count = 0;
			Queue<Integer> q = new LinkedList<>();

			
			

			for (int i = 1; i <= n; i++) {

				if (visited[i] == false) {
					q.add(i);
					visited[i] = true;
					count++;
					while (!q.isEmpty()) {

						int x = q.poll();

						for (int j = 0; j < list.get(x).size(); j++) {

							if (visited[list.get(x).get(j)] == false) {
								q.add(list.get(x).get(j));

								visited[list.get(x).get(j)] = true;
							}
						}
					}
				}
			}
			
			System.out.println(count);
	}

}