import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class node implements Comparable<node> {
		int to;
		int time;

		public node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	static List<List<node>> list;
	static int n;
	static int m;
	static int x;
	static boolean[] visited;
	static PriorityQueue<node> pq;
	static int[] goparty;
	static int[] comeback;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 파티 참여 인원
		n = sc.nextInt();

		// 마을 내 도로 갯수
		m = sc.nextInt();

		// 목적지
		x = sc.nextInt();

		// 각각의 학생들은 자신의 마을에서 최단거리로 파티장소까지 갔다가 돌아올 것.
		// 도로는 단방향 가장 많은 시간을 소비하는 학생은?

		list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			list.get(sc.nextInt()).add(new node(sc.nextInt(), sc.nextInt()));
		}

		goparty = new int[n + 1];
		comeback = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			goparty[i] = Integer.MAX_VALUE;
			comeback[i] = Integer.MAX_VALUE;
		}

		pq = new PriorityQueue<>();

		// 오는거 먼저 구해두자.

		pq.add(new node(x, 0));
		comeback[x] = 0;

		while (!pq.isEmpty()) {
			node now = pq.poll();
//			System.out.println(now.to+" "+now.time);

			if (now.time > comeback[now.to])
				continue;

			for (int i = 0; i < list.get(now.to).size(); i++) {
				node next = list.get(now.to).get(i);
				if (now.time + next.time < comeback[next.to]) {
					comeback[next.to] = now.time + next.time;
					pq.add(new node(next.to, comeback[next.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(comeback));
		
		
		for (int i = 1; i < n + 1; i++) {
			pq = new PriorityQueue<>();
			pq.add(new node(i, 0));
			int[] copygo = goparty.clone();
			copygo[i] = 0;
			while (!pq.isEmpty()) {
				node now = pq.poll();
				
				if (now.to == x) {
					comeback[i] += now.time;
//					System.out.println(i + "는 파티장 4까지" + now.time+"걸림");
					break;
				}

				if (now.time > copygo[now.to])
					continue;

				for (int j = 0; j < list.get(now.to).size(); j++) {
					node next = list.get(now.to).get(j);
					if (now.time + next.time < copygo[next.to]) {
						copygo[next.to] = now.time + next.time;
						pq.add(new node(next.to, copygo[next.to]));
					}
				}
			}

		}
		
		int ans = 0;
		for(int i = 1 ; i< n+1 ; i++) {
			if(comeback[i] > ans) {
				ans = comeback[i];
				
			}
		}
		System.out.println(ans);
//		System.out.println(Arrays.toString(comeback));

//		for(int i = 1 ; i< n+1 ; i++) {
//			visited[i] = true;
//			pq.addAll(list.get(i));
//			
//			for(int j = 0 ; j < list.get(i).size() ; i++) {
//				
//			}
//			
//		}

	}
}