import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] dist;
	static int[][] map;
	static List<spot>[] list;
	static int n;

	static class spot {
		int[] start;
		int[] end;
		int weight;

		public spot(int[] start, int[] end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		for (int test = 1; ; test++) {

			n = sc.nextInt();
			if(n == 0) break;
			map = new int[n][n];

			// 최단시간 저장 배열..
			 dist = new int[n][n];

//			list = new ArrayList[n * n];
//			for (int i = 0; i < n * n; i++) {
//				list[i] = new ArrayList<>();
//			}
			
			
			for(int i = 0 ; i< n ; i++) {
				for(int j = 0 ; j< n ; j++) {
					
					map[i][j] = sc.nextInt();
				}
			}
			
//			for(int i = 0 ; i< n ; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			for(int i = 0 ; i< n ; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			}

//			int num = 0;

//			for (int i = 0; i < n; i++) {
//				String[] arr = sc.next().split("");
//				for (int j = 0; j < n; j++) {
//					int weight = Integer.parseInt(arr[j]);
//
//					for (int d = 0; d < 4; d++) {
//						if (i + dx[d] >= 0 && i + dx[d] < n && j + dy[d] >= 0 && j + dy[d] < n) {
//
//							list[n * (i + dx[d]) + (j + dy[d])]
//									.add(new spot(new int[] { i + dx[d], j + dy[d] }, new int[] { i, j }, weight));
//
//						}
//
//					}
//					num++;
//				}
//			}

			// 시작 노드 0,0;
			// 목표 노드 n-1,n-1;
			
			dijkstra(0,0);
			
//			for(int i = 0 ; i< n ; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			
			System.out.println("Problem "+test+": "+(dist[n-1][n-1]));

		}
		
		
	}
	
	public static void dijkstra(int startx, int starty) {
		boolean[][] visited = new boolean[n][n];
		
		dist[startx][starty] = map[startx][starty];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< n ; j++) {
				
				int min = Integer.MAX_VALUE;
				int xidx = -1;
				int yidx = -1;
				
				for(int x = 0 ; x< n ; x++) {
					for(int y = 0 ; y<n ; y++) {
						if(!visited[x][y] && min > dist[x][y]) {
							min = dist[x][y];
							xidx = x;
							yidx =y;
						}
						
					}
				}
				
				if(xidx == -1) break;
				
				visited[xidx][yidx] = true;
				
				for(int d = 0 ; d< 4 ;d++) {
					if(xidx + dx[d] >= 0 && xidx + dx[d] < n && yidx + dy[d] >= 0 && yidx + dy[d] < n && !visited[xidx+dx[d]][yidx+dy[d]]) {
						if(dist[xidx+dx[d]][yidx+dy[d]] > dist[xidx][yidx]+map[xidx+dx[d]][yidx+dy[d]]) {
						dist[xidx+dx[d]][yidx+dy[d]] = dist[xidx][yidx]+map[xidx+dx[d]][yidx+dy[d]];
						}
					}
				}
//				for(int a = 0 ; a< n ; a++) {
//				System.out.println(Arrays.toString(dist[a]));
//				}
//				System.out.println();
			}
		}
		
		
	}

}