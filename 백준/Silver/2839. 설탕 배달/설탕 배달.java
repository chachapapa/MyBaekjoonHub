import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int res = 5000;

		for (int x = 0;; x++) {
			if (3 * x > n) {
				break;
			}
			for (int y = 0;; y++) {
				if (3 * x + 5 * y == n && x + y < res) {
					res = x + y;
				} else if (3 * x + 5 * y > n) {
					break;
				}
			}
		}
		if (res == 5000) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}

	}

}