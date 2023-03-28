import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] cheese;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		int t = sc.nextInt();

//		for (int test = 1; test <= t; test++) {

			int n = sc.nextInt();

			cheese = new int[n + 2][n + 2];

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {

					cheese[i][j] = sc.nextInt();
				}
			}
			
			
			
			int max = 0;
			for (int day = 0; day < 101; day++) {
				
				int count = 0;
				boolean[][] visited = new boolean[n + 2][n + 2];
				
				
				for (int i = 1; i < n + 1; i++) {
					for (int j = 1; j < n + 1; j++) {
						
						if (cheese[i][j] > day && visited[i][j] ==false) {
							
							count++;
							Queue<int[]> q = new LinkedList<int[]>();
							q.add(new int[] { i, j });
							visited[i][j] = true;

							while (!q.isEmpty()) {
								int[] now = q.poll();
								for (int d = 0; d < 4; d++) {
									if (cheese[now[0] + dx[d]][now[1] + dy[d]] > day && visited[now[0] + dx[d]][now[1] + dy[d]] == false) {
										q.add(new int[] { now[0] + dx[d], now[1] + dy[d] });
										visited[now[0] + dx[d]][now[1] + dy[d]] = true;
									}

								}

							}
							

						}
					}
				}
				if(count>=max) {
					max = count;
				}

			}
			
			System.out.println(max);

		}

//	}

}