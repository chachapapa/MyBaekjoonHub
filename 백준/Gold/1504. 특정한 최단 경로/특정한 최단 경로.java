import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int e = sc.nextInt();

		List<List<node>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int length = sc.nextInt();

			list.get(start).add(new node(end, length));
			list.get(end).add(new node(start, length));
		}

		int[] through = new int[2];
		through[0] = sc.nextInt();
		through[1] = sc.nextInt();

		
		int route1 = 0;
		int route2 = 0;
		
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1, 0));
		int[] start = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			start[i] = Integer.MAX_VALUE;
		}
		start[1] = 0;

		while (!pq.isEmpty()) {
			node now = pq.poll();

			if (now.length > start[now.to])
				continue;

			for (int i = 0; i < list.get(now.to).size(); i++) {
				node next = list.get(now.to).get(i);
				if (now.length + next.length < start[next.to]) {
					start[next.to] = now.length + next.length;
					pq.add(new node(next.to, now.length + next.length));
				}
			}

		}
		
		
		
		pq.add(new node(n, 0));
		int[] last = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			last[i] = Integer.MAX_VALUE;
		}
		last[n] = 0;

		while (!pq.isEmpty()) {
			node now = pq.poll();

			if (now.length > last[now.to])
				continue;

			for (int i = 0; i < list.get(now.to).size(); i++) {
				node next = list.get(now.to).get(i);
				if (now.length + next.length < last[next.to]) {
					last[next.to] = now.length + next.length;
					pq.add(new node(next.to, now.length + next.length));
				}
			}

		}
		
		
		
		route1 += start[through[0]];
		route2 += start[through[1]];
		route1+= last[through[1]];
		route2+= last[through[0]];
//		System.out.println(Arrays.toString(start));
//		System.out.println(Arrays.toString(last));
		
		boolean noroute = true;
		
		pq.add(new node(through[0], 0));
		int[] next1 = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			next1[i] = Integer.MAX_VALUE;
		}
		next1[through[0]] = 0;

		while (!pq.isEmpty()) {
			node now = pq.poll();

			if (now.to == through[1]) {
				route1+= now.length;
				route2+= now.length;
				break;
			}

			if (now.length > next1[now.to])
				continue;

			for (int i = 0; i < list.get(now.to).size(); i++) {
				node next = list.get(now.to).get(i);
				if (now.length + next.length < next1[next.to]) {
					next1[next.to] = now.length + next.length;
					pq.add(new node(next.to, now.length + next.length));
				}
			}

		}
		
		if(next1[through[1]] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		
//		System.out.println(Arrays.toString(start));
//
//		pq = new PriorityQueue<>();
//		pq.add(new node(through[1], 0));
//		next1 = new int[n + 1];
//
//		for (int i = 1; i < n + 1; i++) {
//			next1[i] = Integer.MAX_VALUE;
//		}
//		next1[through[1]] = 0;
//
//		while (!pq.isEmpty()) {
//			node now = pq.poll();
//
//			if (now.to == through[0]) {
////				start[through[1]] += now.length;
//				route2+=now.length;
//				break;
//			}
//
//			if (now.length > next1[now.to])
//				continue;
//
//			for (int i = 0; i < list.get(now.to).size(); i++) {
//				node next = list.get(now.to).get(i);
//				if (now.length + next.length < next1[next.to]) {
//					next1[next.to] = now.length + next.length;
//					pq.add(new node(next.to, now.length + next.length));
//				}
//			}
//
//		}
//		

		if((start[through[0]] == Integer.MAX_VALUE || last[through[1]] == Integer.MAX_VALUE)&&(last[through[0]] == Integer.MAX_VALUE || start[through[1]] == Integer.MAX_VALUE)) {
			System.out.println(-1);
			return;
		}
		
		
//		System.out.println(Arrays.toString(start));
		
		
		System.out.println(Integer.min(route1, route2));
		
		
	}

}