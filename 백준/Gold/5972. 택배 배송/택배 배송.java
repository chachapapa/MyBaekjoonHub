import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class road implements Comparable<road> {
		int end;
		int cow;

		public road(int end, int cow) {
			this.end = end;
			this.cow = cow;
		}

		@Override
		public int compareTo(road o) {
			return Integer.compare(this.cow, o.cow);
		}

		@Override
		public String toString() {
			return "road [end=" + end + ", cow=" + cow + "]";
		}
		
		
	}

	static int n;
	static int d;
	static int min;
	static List<List<road>> list;
	static boolean[] visited;
	static int[] res;
	static PriorityQueue<road> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 노드 갯수
		n = sc.nextInt();

		// 간선 수
		d = sc.nextInt();

		list = new ArrayList<>();

		for (int i = 1; i <= n + 1; i++) {
			list.add(new ArrayList<>());
		}

		res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);

		for (int i = 0; i < d; i++) {
			int start = sc.nextInt();
			int to = sc.nextInt();
			int gogi = sc.nextInt();
			list.get(start).add(new road(to, gogi));
			list.get(to).add(new road(start, gogi));
		}

		visited = new boolean[n + 1];
		q = new PriorityQueue<road>();

		letsgo(1);
//		System.out.println(Arrays.toString(res));
//		System.out.println(Arrays.toString(visited));

		System.out.println(min);

	}

	public static void letsgo(int now) {

		res[now] = 0;
		visited[now] = true;

		q.addAll(list.get(now));

		int pick = 1;
		min = 0;
		while (!q.isEmpty()) {
			road curr = q.poll();
			if (visited[curr.end])
				continue;
			for (int i = 0; i < list.get(curr.end).size(); i++) {
				q.add(new road(list.get(curr.end).get(i).end, list.get(curr.end).get(i).cow + curr.cow));
			}
			visited[curr.end] = true;
			if(curr.end == n) min = curr.cow;
		}

//		if (now == n) {
//			if (sum < min) {
//				min = sum;
//			}
//			return;
//		}
//		if(sum > min) {
//			return;
//		}
//		int tmpmin = 1000;
//		int whereto= 0;
//		for (int i = 0; i < list.get(now).size(); i++) {
//			if (visited[list.get(now).get(i).end] == false) {
//				
//				if(list.get(now).get(i).cow<tmpmin) {
//				tmpmin = list.get(now).get(i).cow;
//				whereto = list.get(now).get(i).end;
//				}
//			}
//		}
//		
//		visited[whereto] = true;
//		letsgo(whereto, sum + tmpmin);
//		visited[whereto] = false;
	}
}