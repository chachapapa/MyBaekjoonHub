import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class node{
		int from;
		int to;
		int cost;
		
		public node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
	}
	
	static int n;
	static int m;
	static List<node> list;
	static int linecount;
	static int linenum;
	static int[] p;
	static int ans;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//노드 수
		n = sc.nextInt();
		
		//간선 수
		m = sc.nextInt();
		
		list = new ArrayList<>();
		
		
		for(int i = 0 ; i < m ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			
			list.add(new node(start, end , cost));
		}
		
		Collections.sort(list, new Comparator<node>() {

			@Override
			public int compare(node o1, node o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		
//		System.out.println(list.toString());
		
		
		linecount = 0 ;
		linenum = 0;
		
		p = new int[n+1];
		
		for(int i = 0 ; i < n+1 ; i++) {
			p[i] = i ;
		} 
		
		ans = 0;
		while(linenum < m) {
			
			
			
			int px = findset(list.get(linenum).from);
			int py = findset(list.get(linenum).to);
			
			
			if(px != py) {
				union(px, py);
				linecount++;
				ans += list.get(linenum).cost;
			}
			
//			System.out.println(Arrays.toString(p));
			
			linenum++;
			
			
			if(linecount == n-1) break;
		}
		System.out.println(ans);
	}
	
	
	public static int findset(int node) {
		
		if (node != p[node]) {
			p[node] = findset(p[node]);
		}
		return p[node];
		
	}
	
	public static void union(int x, int y) {
		p[y] = x;
	}

}