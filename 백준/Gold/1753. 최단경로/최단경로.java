import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int v;
	static int e;
	static int start;
	static List<Node>[] list;
	static int[] res;
	static PriorityQueue<Node> pq;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();

		e = sc.nextInt();

		start = sc.nextInt();

		list = new ArrayList[v + 1];

		for (int i = 0; i < v + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			list[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		res = new int[v + 1];
		for (int i = 0; i < v + 1; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		pq = new PriorityQueue<Node>();
		stra(start);

		for (int i = 1; i < v + 1; i++) {
			if (res[i] != Integer.MAX_VALUE) {
				System.out.println(res[i]);
			} else {
				System.out.println("INF");
			}
		}
	}

	public static void stra(int start) {

		visited = new boolean[v + 1];

		pq.add(new Node(start, 0));
		res[start] = 0;
		visited[start] = true;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (int i = 0; i < list[now.end].size(); i++) {

				if (visited[list[now.end].get(i).end] == false
						&& res[list[now.end].get(i).end] > now.weight + list[now.end].get(i).weight) {
					pq.add(new Node(list[now.end].get(i).end, now.weight + list[now.end].get(i).weight));
					res[list[now.end].get(i).end] = now.weight + list[now.end].get(i).weight;
				}

			}

//			System.out.println(Arrays.toString(res));
		}

	}

}