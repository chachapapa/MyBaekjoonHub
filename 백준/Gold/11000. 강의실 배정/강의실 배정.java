import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int start;
	static PriorityQueue<Integer> q;
	static int[][] tmp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		tmp = new int[n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				tmp[i][j] = sc.nextInt();
			}
		}

		Arrays.sort(tmp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
			}
		});

		q = new PriorityQueue<>();
		
		
		timetable();
		System.out.println(q.size());
	}

	public static void timetable() {
		
		q.add(tmp[0][1]);
		
		for(int i = 1; i<tmp.length ; i++ ) {
			if(tmp[i][0] >= q.peek()) {
				q.poll();
				q.add(tmp[i][1]);

			}else {
				q.add(tmp[i][1]);
			}
			
		}
	}

}