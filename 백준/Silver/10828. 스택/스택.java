import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] order = new String[n];

		sc.nextLine();

		for (int i = 0; i < n; i++) {

			order[i] = sc.nextLine();
		}


		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < order.length; i++) {

			if (order[i].contains("push")) {
				stack.push(Integer.parseInt(order[i].split(" ")[1]));
			} else if (order[i].equals("pop")) {
				if (!stack.isEmpty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			} else if (order[i].equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (order[i].equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (order[i].equals("top")) {
				if (!stack.isEmpty()) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}

		}
		System.out.println(sb);
	}

}
