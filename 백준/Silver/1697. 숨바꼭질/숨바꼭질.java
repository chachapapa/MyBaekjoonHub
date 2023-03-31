import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int min;
	static int route;
	static Queue<int[]> q;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		route = 0;
		min = 100000;
		q = new LinkedList<>();
		visit = new boolean[100001];

		find(x, y, 0);

		System.out.println(min);

	}

	public static void find(int start, int goal, int time) {

		int[] arr = { start, time };
		q.add(arr);

		while (!q.isEmpty()) {

			int[] now = q.poll();

			visit[now[0]] = true;

			if (now[0] > goal) {
				now[1] += now[0] - goal;
				now[0] = goal;

				if (now[1] < min) {

					min = now[1];
					route = 1;
				} else if (now[1] == min) {
					route++;
				}
			} else {

				if (now[0] == goal) {

					if (now[1] < min) {

						min = now[1];
						route = 1;
					} else if (now[1] == min) {
						route++;
					}

				} else {

					if (visit[now[0] + 1] == false) {
						int[] next1 = { now[0] + 1, now[1] + 1 };
						q.add(next1);
					}
					if (now[0] - 1 >= 0 && visit[now[0] - 1] == false) {
						int[] next2 = { now[0] - 1, now[1] + 1 };
						q.add(next2);
					}
					if (now[0] * 2 < 100001 && visit[now[0] * 2] == false) {
						int[] next3 = { now[0] * 2, now[1] + 1 };
						q.add(next3);
					}

				}
			}

		}

	}
}
