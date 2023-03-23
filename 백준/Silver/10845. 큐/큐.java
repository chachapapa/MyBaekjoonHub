import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] order = new String[n];

		sc.nextLine();

		for (int i = 0; i < n; i++) {

			order[i] = sc.nextLine();
		}

		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < order.length; i++) {

			if (order[i].contains("push")) {
				q.add(Integer.parseInt(order[i].split(" ")[1]));
			} else if (order[i].equals("pop")) {
				if (!q.isEmpty()) {
					sb.append(q.poll() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			} else if (order[i].equals("size")) {
				sb.append(q.size() + "\n");
			} else if (order[i].equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (order[i].equals("front")) {
				if (!q.isEmpty()) {
					sb.append(q.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			} else if (order[i].equals("back")) {
				if (q.size() > 0) {
					for(int x = 0; x<q.size()-1 ; x++) {
						q.add(q.poll());
					}
					int x = q.poll();
					sb.append(x + "\n");
					q.add(x);
				} else {
					sb.append(-1 + "\n");
				}
			}

		}
		System.out.println(sb);

	}

}
