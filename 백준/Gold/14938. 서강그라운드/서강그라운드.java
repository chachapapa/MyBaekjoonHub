import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int to;
		int length;
		
		
		public Node(int to, int length) {
			this.to = to;
			this.length = length;
		}


		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.length, o.length);
		}
	}
	
	
	static int n;
	static int m;
	static int r;
	static int[] items;
	static List<List<Node>> list;
	static int[] res;
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) {

		// 가중치 한계가 주어짐.
		// 다익스트라는 각 노드까지의 최솟값을 구할 수 있음.
		// 모든 노드를 시작점으로 두고, 최솟값 구한뒤, 갈 수 있는 노드의 아이템 합 구하기.
		// 시작지점은 어디든 가능
		// 각 노드별 아이템 수 배열.
		// 아이템의 합 중 최댓값을 구해라..
		
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		
		items = new int[n+1];
		
		for(int i = 1 ; i< n+1 ; i++) {
			items[i] = sc.nextInt();
		}
		
		list = new ArrayList<>();
		
		for(int i = 0 ; i< n+1 ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < r ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int length = sc.nextInt();
			list.get(start).add(new Node(end, length));
			list.get(end).add(new Node(start, length));
		}
		res = new int[n+1];
		int max = 0;
		for(int start = 1 ; start<n+1 ; start++) {
			
			for(int i = 0 ; i< n+1 ; i++) {
				res[i] = Integer.MAX_VALUE;
			}
			visited = new boolean[n+1];
			pq = new PriorityQueue<>();
			stra(start);
			
			int sum = 0;
			for(int i = 1 ; i < n+1 ; i++) {
				if(res[i] <= m) {
					sum += items[i];
				}
			}
			
			if(max < sum) {
				max = sum;
			}
			
		}
		
		System.out.println(max);
	}
	
	public static void stra(int start) {
		pq.add(new Node(start, 0));
		res[start] = 0;
		
		
		while(!pq.isEmpty()) {
			
			Node now = pq.poll();
			visited[now.to] = true;
			for(int i = 0 ; i< list.get(now.to).size() ; i++) {
				if(visited[list.get(now.to).get(i).to] == false && now.length+list.get(now.to).get(i).length < res[list.get(now.to).get(i).to]) {
					res[list.get(now.to).get(i).to] = now.length+list.get(now.to).get(i).length;
					pq.add(new Node(list.get(now.to).get(i).to, now.length+list.get(now.to).get(i).length));
				}
			}
			
		}
		
		
		
	}
}