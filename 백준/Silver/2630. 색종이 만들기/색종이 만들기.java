import java.util.Scanner;

public class Main {

	static int n;
	static int[][] paper;
	static int white;
	static int blue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		white = 0;
		blue = 0;

		cut(0, n, 0, n);

		System.out.println(white);
		System.out.println(blue);

	}

	public static void cut(int xstart, int xend, int ystart, int yend) {
//		System.out.println(xstart + " " + xend + " " + ystart + " " + yend);

		if (xstart >= xend || ystart >= yend)
			return;

		int whitecount = 0;
		int bluecount = 0;

		for (int i = xstart; i < xend; i++) {
			for (int j = ystart; j < yend; j++) {

				if (paper[i][j] == 0) {
					whitecount++;
				} else {
					bluecount++;
				}

				if (bluecount != 0 && whitecount != 0) {

					cut(xstart, xstart + (xend - xstart) / 2, ystart, ystart + (yend - ystart) / 2);
					cut(xstart + (xend - xstart) / 2, xend, ystart, ystart + (yend - ystart) / 2);
					cut(xstart, xstart + (xend - xstart) / 2, ystart + (yend - ystart) / 2, yend);
					cut(xstart + (xend - xstart) / 2, xend, ystart + (yend - ystart) / 2, yend);

					return;
				}
			}
		}

		if (whitecount ==0) blue++;
		if (bluecount == 0) white++;

	}

}