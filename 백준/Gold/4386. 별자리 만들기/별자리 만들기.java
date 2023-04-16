import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class star{
		double x;
		double y;
		
		public star(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class line implements Comparable<line>{
		int eidx;
		double dist;
		
		
		public line(int eidx, double dist) {
			this.eidx = eidx;
			this.dist = dist;
		}



		@Override
		public int compareTo(line o) {
			return Double.compare(this.dist, o.dist);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		//프림으로 풀기
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<star> list = new ArrayList<>();
		
		for(int i = 0 ; i< n ; i++) {
			list.add(new star(sc.nextDouble(),sc.nextDouble()));
		}
		
		List<List<line>> lines = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			lines.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < n-1 ; i++) {
			for(int j = i+1 ; j< n ; j++) {
				lines.get(i).add(new line(j, Math.sqrt(Math.pow(list.get(i).x-list.get(j).x, 2)+Math.pow(list.get(i).y-list.get(j).y, 2))));
				lines.get(j).add(new line(i, Math.sqrt(Math.pow(list.get(i).x-list.get(j).x, 2)+Math.pow(list.get(i).y-list.get(j).y, 2))));
			}
		}
		
		boolean[] visited = new boolean[n];
		PriorityQueue<line> pq = new PriorityQueue<>();
		visited[0] = true;
		
		pq.addAll(lines.get(0));
		
		int pick = 1;
		double ans = 0;
		
		while(pick != n) {
			line l = pq.poll();
			
			if(visited[l.eidx]) continue;
			
			ans += l.dist;
			pq.addAll(lines.get(l.eidx));
			visited[l.eidx] = true;
			pick++;
		}
		
		System.out.printf("%.2f",ans);
	}

}