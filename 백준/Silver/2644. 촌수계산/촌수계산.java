import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 노드(사람) 갯수
		int n = sc.nextInt();
		// 촌수 계산할 사람 x, y
		int x = sc.nextInt();
		int y = sc.nextInt();

		// 간선(관계) 갯수
		int m = sc.nextInt();
		
//		System.out.println("노드" +  n + " x , y" + x+ y + " 간선 수" + m);

		List<List<Integer>> gamoon = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			gamoon.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int start =sc.nextInt();
			int end = sc.nextInt();
			
			gamoon.get(start).add(end);
			gamoon.get(end).add(start);
			
		}

		Queue<int[]> q = new LinkedList<>();

		// BFS를 위한 정렬. 작은수부터 들어감.
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(gamoon.get(i), new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
		}
		
		boolean[] visited = new boolean[n + 1];
		int[] wonso = {x,0};
		
		q.add(wonso);
		visited[x] = true;
		
		int res = 0;
		while (!q.isEmpty()) {
			
			
			int[] base = q.poll(); 
			
			for (int i = 0; i < gamoon.get(base[0]).size(); i++) {
				
				if (visited[gamoon.get(base[0]).get(i)] == false) {
					
					if(gamoon.get(base[0]).get(i) == y) {
						res = base[1]+1;
					}
					
					
					int[] tmp = {gamoon.get(base[0]).get(i),base[1]+1};
					
//					System.out.println(Arrays.toString(tmp));
					q.add(tmp);
					visited[gamoon.get(base[0]).get(i)] = true;
					
				}
			}
			
		}
		
		
		if(res != 0) {
			System.out.println(res);
		}else {
			System.out.println(-1);
		}
		
		
	}

}