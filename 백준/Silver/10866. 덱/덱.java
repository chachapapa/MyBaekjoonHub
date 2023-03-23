import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);

		String[] order = new String[n];


		for (int i = 0; i < n; i++) {

			order[i] = br.readLine();
		}

		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < order.length; i++) {

			if (order[i].contains("push_front")) {
				dq.addFirst(Integer.parseInt(order[i].split(" ")[1]));
			} else if (order[i].contains("push_back")) {
				dq.addLast(Integer.parseInt(order[i].split(" ")[1]));
			} else if (order[i].equals("pop_front")) {
				if (!dq.isEmpty()) {
					sb.append(dq.pollFirst() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}else if (order[i].equals("pop_back")) {
				if (!dq.isEmpty()) {
					sb.append(dq.pollLast() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}else if (order[i].equals("size")) {
				sb.append(dq.size() + "\n");
			} else if (order[i].equals("empty")) {
				if (dq.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (order[i].equals("front")) {
				if (!dq.isEmpty()) {
					sb.append(dq.peekFirst()+ "\n");
				} else {
					sb.append(-1 + "\n");
				}
			} else if (order[i].equals("back")) {
				if (!dq.isEmpty()) {
					sb.append(dq.peekLast()+ "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}

		}
		
		System.out.println(sb);

	}

}
