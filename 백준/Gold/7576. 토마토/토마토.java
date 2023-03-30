import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int[][] box = new int[n][m];

		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		List<int[]> yammy = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				box[i][j] = sc.nextInt();
				if (box[i][j] == 1) {
					yammy.add(new int[] { i, j });
				}

//				if(box[i][j] == -1) {
//					visited[i][j] = true;
//				}
			}
		}

		int min = 0;
		for (int i = 0; i < yammy.size(); i++) {
//			int max = 0;

			
			q.add(yammy.get(i));
			visited[yammy.get(i)[0]][yammy.get(i)[1]] = true;
			box[yammy.get(i)[0]][yammy.get(i)[1]] = 0;

		}
		while (!q.isEmpty()) {

			int[] now = q.poll();

			for (int j = 0; j < 4; j++) {
				if (now[0] + dx[j] >= 0 && now[0] + dx[j] < n && now[1] + dy[j] >= 0 && now[1] + dy[j] < m) {
					if (visited[now[0] + dx[j]][now[1] + dy[j]] == false && box[now[0] + dx[j]][now[1] + dy[j]] == 0) {
//							if (box[now[0] + dx[j]][now[1] + dy[j]] == 0) {
						box[now[0] + dx[j]][now[1] + dy[j]] = box[now[0]][now[1]] + 1;
//
////								max = box[now[0]][now[1]] + 1;
						visited[now[0] + dx[j]][now[1] + dy[j]] = true;
						q.add(new int[] { now[0] + dx[j], now[1] + dy[j] });
//							} else if (box[now[0] + dx[j]][now[1] + dy[j]] >= box[now[0]][now[1]] + 1) {
//								box[now[0] + dx[j]][now[1] + dy[j]] = box[now[0]][now[1]] + 1;
////								max = box[now[0]][now[1]] + 1;
//								visited[now[0] + dx[j]][now[1] + dy[j]] = true;
//								q.add(new int[] { now[0] + dx[j], now[1] + dy[j] });
//							}
					}
				}
//
//				}

			}

//			if (max < min) {
//				min = max;
//			}

//			for (int x = 0; x < n; x++) {
//				System.out.println(Arrays.toString(box[x]));
//			}
//			System.out.println(min);
//			System.out.println();
			
		}
		
		for (int i = 0; i < yammy.size(); i++) {
			box[yammy.get(i)[0]][yammy.get(i)[1]] = -2;
		}

//		for(int i = 0 ; i < n ; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}

		loop: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (box[i][j] > min) {
					min = box[i][j];
				}
//
				if (box[i][j] == 0) {
					min = -1;
					break loop;
				}
//				if(!visited[i][j]) {
//					min = -1;
//					break loop;
//				}
			}
		}

//		
//		for(int i = 0 ; i< n ; i++) {
//			System.out.println(Arrays.toString(box[i]));
//		}
		System.out.println(min);
	}

}