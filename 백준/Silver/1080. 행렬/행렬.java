import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] A = new int[n][m];
		int[][] B = new int[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < m; j++) {
				A[i][j] = (tmp.toCharArray()[j] - '0');
			}
		}

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < m; j++) {
				B[i][j] = (tmp.toCharArray()[j] - '0');
			}
		}

		if (n >= 3 && m >= 3) {
			int count = 0;
			for (int i = 0; i < n - 2; i++) {
				for (int j = 0; j < m - 2; j++) {

					if (A[i][j] != B[i][j]) {
						count++;
						for (int x = i; x < i + 3; x++) {
							for (int y = j; y < j + 3; y++) {

								if (A[x][y] == 0) {
									A[x][y] = 1;
								} else {
									A[x][y] = 0;
								}
							}
						}
					}
				}
			}
			int dif = 0;
			loop: for (int i = n - 1; i >= 0; i--) {
				for (int j = m - 1; j >= 0; j--) {
					if (A[i][j] != B[i][j]) {
						dif++;
						System.out.println(-1);
						break loop;
					}
				}
			}

			if (dif == 0) {
				System.out.println(count);
			}
		} else {
			int dif = 0;
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (A[i][j] != B[i][j]) {
						dif++;
						System.out.println(-1);
						break loop;
					}
				}
			}
			if(dif == 0) {
				System.out.println(0);
			}
		}
	}

}