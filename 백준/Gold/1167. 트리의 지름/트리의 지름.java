import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class node {
		int to;
		int length;

		public node(int to, int length) {
			this.to = to;
			this.length = length;
		}

		@Override
		public String toString() {
			return "node [to=" + to + ", length=" + length + "]";
		}

	}

	static List<node>[] arr;
	static int n;
	static boolean[] visited;
	static int max;
	static int again;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		arr = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 1; i < n + 1; i++) {
			int x = sc.nextInt();
			while (true) {
				int to = sc.nextInt();
				if (to == -1)
					break;
				int length = sc.nextInt();
				arr[x].add(new node(to, length));
			}
		}
		max = 0;
		visited = new boolean[n+1];
		
		dfs(1,0);
	
		visited = new boolean[n+1];
		dfs(again,0);
		
		System.out.println(max);
	}
	
	public static void dfs(int node, int length) {
		
		
		if(length > max) {
			max = length;
			again = node;
		}
		
		visited[node] = true;
		
		for(int i = 0 ; i< arr[node].size() ; i++) {
			if(!visited[arr[node].get(i).to]) {
				visited[arr[node].get(i).to] = true;
				dfs(arr[node].get(i).to,length+arr[node].get(i).length);

			}
		}
		
	}

}