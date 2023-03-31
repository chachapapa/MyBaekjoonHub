import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int number = 0;
		// 그래프를 만들기 위한 미로 생성
		int[][] maze = new int[n + 2][m + 2];
//		boolean[][] copy = new boolean[n + 2][m + 2];
		
		for (int i = 1; i < n+1; i++) {
			String[] arr = sc.next().split("");
			for (int j = 1; j < m + 1; j++) {
				if (Integer.parseInt(arr[j-1]) == 1) {
					maze[i][j] = ++number;
				}
			}
		}
		/*for(int i = 0 ; i<n+2 ; i++) {
			System.out.println(Arrays.toString(maze[i]));
		}*/

		int goal = maze[n][m];
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < number + 1; i++) {
			list.add(new ArrayList<>());
		}

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (maze[i][j] != 0) {
					//copy[i][j] = true;
					for (int x = 0; x < 4; x++) {
							if (maze[i + dx[x]][j + dy[x]] != 0) {
								int[] tmpend = { i + dx[x], j + dy[x] };
								//System.out.println(Arrays.toString(tmpend));
								list.get(maze[i][j]).add(maze[tmpend[0]][tmpend[1]]);
								list.get(maze[tmpend[0]][tmpend[1]]).add(maze[i][j]);
								//copy[i + dx[x]][j + dy[x]] = true;
							}
					}
				}
			}
		}
		
		/*for(int i = 0 ; i< number+1 ; i++) {
			System.out.println(i + " " +list.get(i));
		}*/
		for (int i = 1; i < number + 1; i++) {
			Collections.sort(list.get(i));
		}

		boolean[] visited = new boolean[number + 1];

		Queue<int[]> q = new LinkedList<>();
		int[] gogo= { 1, 1 };
		visited[1] = true;
		q.add(gogo);
		int res = 10000;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < list.get(now[0]).size(); i++) {
				
				
				if(list.get(now[0]).get(i) == goal) {
					if(res>now[1]+1) {
					res = now[1]+1;
					}
				}
				
				if (!visited[list.get(now[0]).get(i)]) {
					
					
					int[] tmp = { list.get(now[0]).get(i), now[1] + 1 };
					
					q.add(tmp);
					visited[list.get(now[0]).get(i)] = true;
				}
			}
			
			
			
			

		}
		
		System.out.println(res);

	}

}