import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int start;
	static int count;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return Integer.compare(o1[0], o2[0]);
				else
					return Integer.compare(o1[1], o2[1]);
			}

		});

		timetable();

		System.out.println(count);
	}

	public static void timetable() {
		count++;
		start = arr[0][1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] >= start) {
				count++;
				start = arr[i][1];
			}
		}

	}

}