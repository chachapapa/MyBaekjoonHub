import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class status {
		int nx;
		int ny;
		int time;
		int items;

		public status(int nx, int ny, int time, int items) {
			this.nx = nx;
			this.ny = ny;
			this.time = time;
			this.items = items;

		}

		@Override
		public String toString() {
			return "status [nx=" + nx + ", ny=" + ny + ", time=" + time + ", items=" + items + "]";
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] map = new char[n][m];
		boolean[][][] visited = new boolean[64][n][m];

		for (int i = 0; i < n; i++) {

			map[i] = sc.next().toCharArray();

		}

		// . 빈칸
		// # 벽
		// abcdef 열쇠
		// ABCDEF 문
		// 0 현재 민식이 위치. 빈칸임
		// 1 출구

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<status> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (map[i][j] == '0') {
					q.add(new status(i, j, 0, 0));
					visited[0][i][j] = true;
				}

			}
		}

		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			status now = q.poll();

//			System.out.println(now.toString());

			if (map[now.nx][now.ny] == '1') {
				min = now.time;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int mx = now.nx + dx[d];
				int my = now.ny + dy[d];

				// 맵내부, 현재 인벤창의 visited가 false일때만
				if (mx >= 0 && mx < n && my >= 0 && my < m) {
					if (!visited[now.items][mx][my]) {
//						System.out.println("들어왔니~");
						// 빈칸이동
						if (map[mx][my] == '.' || map[mx][my] == '0') {
							q.add(new status(mx, my, now.time + 1, now.items));
							visited[now.items][mx][my] = true;
							// 열쇠줍기
						} else if (map[mx][my] >= 'a' && map[mx][my] <= 'f') {

							if ((now.items & 1 << map[mx][my] - 'A') == 0) {
								q.add(new status(mx, my, now.time + 1,
										(int) (now.items + Math.pow(2, (int) (map[mx][my] - 'a')))));
								visited[(int) (now.items + Math.pow(2, (int) (map[mx][my] - 'a')))][mx][my] = true;
							}else {
								q.add(new status(mx, my, now.time + 1, now.items));
								visited[now.items][mx][my] = true;
							}
							// 문열기
						} else if (map[mx][my] >= 'A' && map[mx][my] <= 'F') {
							if ((now.items & 1 << map[mx][my] - 'A') == Math.pow(2, (int) (map[mx][my] - 'A'))) {
								q.add(new status(mx, my, now.time + 1, now.items));
								visited[now.items][mx][my] = true;
							}
						} else if (map[mx][my] == '1') {
							q.add(new status(mx, my, now.time + 1, now.items));
							visited[now.items][mx][my] = true;
						}

					}
				}
			}

		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}