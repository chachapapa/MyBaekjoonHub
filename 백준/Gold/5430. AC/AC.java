import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		loop : for (int test = 1; test <= t; test++) {

			// 이것도 최대 10만
			char[] command = sc.next().toCharArray();

			String status = "L";

			int n = sc.nextInt();

			// 최대 10만

			Deque<String> dq = new ArrayDeque<>();

			String tmp = sc.next();

			if (tmp.length() > 2) {

				tmp = tmp.substring(1, tmp.length() - 1);
				
				
				String[] arr = tmp.split(",");
				for (int i = 0; i < arr.length; i++) {
					dq.add(arr[i]);

				}

			} else {
				tmp = "";
			}

			
			for (int i = 0; i < command.length; i++) {

				if (command[i] == 'R') {
					if (status.equals("R")) {
						status = "L";
					} else if (status.equals("L")) {
						status = "R";
					}
				}

				if (command[i] == 'D') {
					if (dq.isEmpty()) {
						System.out.println("error");
						continue loop;
					} else if (status.equals("R")) {
						dq.pollLast();
					} else if (status.equals("L")) {
						dq.pollFirst();
					}
				}
			}

			if (dq.isEmpty()) {
				System.out.println("[]");

			} else if (status.equals("R")) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while (!dq.isEmpty()) {
					sb.append(dq.pollLast()).append(",");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
				System.out.println(sb);

			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				while (!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append(",");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append("]");
				System.out.println(sb);
			}

		}

	}

}