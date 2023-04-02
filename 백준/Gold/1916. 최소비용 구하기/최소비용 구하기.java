import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}



		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	
	static int n;
	static int m;
	static int start;
	static int end;
	
	static List<List<Node>> list;
	static int[] res;
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);
		str= br.readLine();
		int m = Integer.parseInt(str);
		
		list = new ArrayList<>();
		for(int i = 0 ; i<n+1 ; i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i = 0 ; i< m ; i++) {
			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp);
			list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		res = new int[n+1];
		
		for(int i = 0 ; i<n+1 ; i++) {
			res[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[n+1];
		stra(start);
		
//		System.out.println(res[end]);
		
	}
	
	public static void stra(int start) {
		pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		res[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.to == end) {
				System.out.println(now.cost);
				break;
			}
			visited[now.to] = true;
			for(int i = 0 ; i < list.get(now.to).size() ; i++) {
				if(visited[list.get(now.to).get(i).to] == false && now.cost+list.get(now.to).get(i).cost < res[list.get(now.to).get(i).to]) {
					res[list.get(now.to).get(i).to] = now.cost+list.get(now.to).get(i).cost;
					pq.add(new Node(list.get(now.to).get(i).to, now.cost+list.get(now.to).get(i).cost));
				}
				
			}
			
		}
		
	}
	
	
}