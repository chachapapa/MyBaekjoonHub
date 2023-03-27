import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static List<List<Integer>> list;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//델타로 사방탐색위해 앞뒤로 배열 늘려줌.
		int[][] land = new int[n + 2][m + 2];

		int count = 0;
		
		//땅인경우 count로 숫자 넣어줌.
		for (int i = 1; i < n + 1; i++) {
			String[] tmp = sc.next().split("");
			for (int j = 1; j < m + 1; j++) {

				if (tmp[j - 1].equals("L")) {
					land[i][j] = ++count;
				}

			}
		}
//		System.out.println(count);
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		//리스트 생성해서 인접 땅 숫자 넣어줌.
		list = new ArrayList<>();

		for (int i = 0; i < count+1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (land[i][j] == 0) {
					continue;
				}

				for (int d = 0; d < 4; d++) {

					if (land[i + dx[d]][j + dy[d]] != 0) {
						list.get(land[i][j]).add(land[i + dx[d]][j + dy[d]]);

					}

				}

			}
		}
		int max = 0;
		int[] now = new int[2];
		min = 2500;

		

		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 1; i <= count; i++) {

			q.add(new int[] { i, 0 });
			visited = new boolean[count+1];
			visited[i] = true;
			
			while (!q.isEmpty()) {

				now = q.poll();

				if (now[1] > max) {
					max = now[1];
				}

				for (int x = 0; x < list.get(now[0]).size(); x++) {
					if (visited[list.get(now[0]).get(x)] == false) {
						q.add(new int[] { list.get(now[0]).get(x), now[1] + 1 });
						visited[list.get(now[0]).get(x)] = true;
					}
				}

			}

		}
		System.out.println(max);

	}

}