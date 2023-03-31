import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test = 1; test <= 4; test++) {

			int[] arr = new int[8];

			for (int i = 0; i < arr.length; i++) {

				arr[i] = sc.nextInt();
			}
			// 안만남
			if (arr[4] - arr[2] > 0 || arr[5] - arr[3] > 0 || arr[0] - arr[6] > 0 || arr[1] - arr[7] > 0) {
				System.out.println("d");

				// 점
			} else if ((arr[2] == arr[4] && arr[3] == arr[5]) || (arr[0] == arr[6] && arr[3] == arr[5])
					|| (arr[0] == arr[6] && arr[1] == arr[7]) || (arr[2] == arr[4] && arr[1] == arr[7])) {
				System.out.println("c");

				// 선분
			} else if ((arr[2] == arr[4] && (arr[3] - arr[5] > 0 || arr[5] - arr[1] > 0))
					|| (arr[3] == arr[5] && (arr[2] - arr[4] > 0 || arr[6] - arr[0] > 0))
					|| (arr[0] == arr[6] && (arr[3] - arr[5] > 0 || arr[7] - arr[1] > 0))
					|| (arr[1] == arr[7] && (arr[2] - arr[4] > 0 || arr[6] - arr[0] > 0))) {
				System.out.println("b");

				// 사각형
			} else {
				System.out.println("a");
			}

		}

	}

}