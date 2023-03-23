import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] people = new int[n];

		Stack<int[]> line = new Stack<>();
		Double count = 0.0;
		for (int i = 0; i < n; i++) {

			int x = sc.nextInt();
			int[] set = new int[2];
			set[0] = x;
			set[1] = 1;

			// 비었을때
			if (line.isEmpty()) {
				line.add(set);
				continue;

				// 뭐라도 들었으면
			} else {
				
				if (line.peek()[0] < x) {

					while (!line.isEmpty() && line.peek()[0] < x) {
						int tmp1 = line.pop()[1];
						count += tmp1;
					}
					
					if(line.isEmpty()) {
					line.add(set);
					continue;
					}
				}

				if (!line.isEmpty() && line.peek()[0] == x) {
					int tmp2 = line.pop()[1];
					set[1] += tmp2;
					count += tmp2;
					if (!line.isEmpty()) {
						count++;
					}
					line.add(set);
				}

				if (!line.isEmpty() && line.peek()[0] > x) {
					count++;
					line.add(set);
				}

			}

		}
		System.out.printf("%.0f",count);
	}
}