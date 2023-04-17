import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class node implements Comparable<node> {
		int to;
		int length;

		public node(int to, int length) {
			this.to = to;
			this.length = length;
		}

		@Override
		public int compareTo(node o) {
			return Integer.compare(this.length, o.length);
		}

		@Override
		public String toString() {
			return "node [to=" + to + ", length=" + length + "]";
		}
		
		
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		List<List<node>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		String[] gender = new String[n + 1];

		for (int i = 1; i < n + 1; i++) {
			gender[i] = sc.next();
		}

		for (int i = 0; i < m; i++) {

			int start = sc.nextInt();
			int end = sc.nextInt();
			int length = sc.nextInt();

			if (gender[start].equals(gender[end]))
				continue;

			list.get(start).add(new node(end, length));
			list.get(end).add(new node(start, length));
		}

		boolean[] visited = new boolean[n + 1];

		PriorityQueue<node> pq = new PriorityQueue<>();

		// 시작정점을 하나 뽑고 할래
		visited[1] = true;
		
		for (int i = 0; i < list.get(1).size(); i++) {
			pq.add(list.get(1).get(i));
		}
		
//		System.out.println(pq);
		int pick = 1; // 확보한 정점의 개수
		int ans = 0;

		while (!pq.isEmpty()) {
			
			if(pick == n) {
				break;
			}

//			boolean check = true;
//			for(int i = 1 ; i<n+1 ; i++) {
//				if(!visited[i]) check = false;
//			}
//			
//			if(check) {
//				System.out.println(-1);
//				break loop;
//			}

			node e = pq.poll();
			if (visited[e.to])
				continue;

			ans += e.length;

			for (int i = 0; i < list.get(e.to).size(); i++) {
				pq.add(list.get(e.to).get(i));
			}

			visited[e.to] = true;
			pick++;
		}
		
		if (pick == n)System.out.println(ans);
		else System.out.println(-1);

	}

}