import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static class Node{
		int num;
		int length;
		
		public Node(int num, int length) {
			this.num = num;
			this.length = length;
		}
	}
	
	static List<Node> list[];
	static boolean visit[];
	static int res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		
		for(int i = 1 ; i < n+1 ; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < n-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,length));
			list[to].add(new Node(from, length));
			
			
		}
				
		res= 0;
		for(int i = 1; i<= n ; i++) {
			
			visit = new boolean[n+1];
			visit[i] = true;
			dfs(i,0);
		}
		
		System.out.println(res);
		
	}
	
	public static void dfs(int n, int d) {
		for(Node node : list[n]) {
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, d+node.length);
			}
		}
		res = (res<d)? d : res; 
	}

}