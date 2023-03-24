import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		char[] arr = str.toCharArray();


		Stack<Character> stack = new Stack<>();

		char[][] icp = { { ' ', ' ' }, { '+', '-' }, { '*', '/' }, { '(', ' ' } };
		char[][] isp = { { '(', ' ' }, { '+', '-' }, { '*', '/' } };
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {

			if (stack.isEmpty()) {
				if (arr[i] == '(' || arr[i] == '+' || arr[i] == '*' || arr[i] == '-' || arr[i] == '/') {
					stack.push(arr[i]);
				} else {
					sb.append(arr[i]);
				}

			} else {
				if (arr[i] == '(' || arr[i] == '+' || arr[i] == '*' || arr[i] == '-' || arr[i] == '/') {
					int cp = 0;
					int sp = 0;
					for (int searchicp = 0; searchicp < icp.length; searchicp++) {

						if (icp[searchicp][0] == arr[i] || icp[searchicp][1] == arr[i]) {

							cp = searchicp;
							break;
						}

					}

					loop: for (int searchisp = 0; searchisp < isp.length;) {

						if (isp[searchisp][0] == stack.peek() || isp[searchisp][1] == stack.peek()) {

							sp = searchisp;

							if (cp > sp) {

								stack.push(arr[i]);
	
								break;
							} else {
								sb.append(stack.pop());
								if(stack.isEmpty()) {
									stack.push(arr[i]);
									break;
								}
								searchisp = 0;
								continue loop;
							}
						}

						searchisp++;
					}

				} else if (arr[i] == ')') {
					while (stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();


				} else {
					sb.append(arr[i]);
				}

			}

		}

		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}