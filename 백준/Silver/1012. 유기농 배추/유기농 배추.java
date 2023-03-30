import java.util.Scanner;

public class Main {

	static int[][] land;
	static int beollae = 0;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int test = 1; test <= t; test++) {
			beollae = 0;
			// 가로
			int m = sc.nextInt();
			// 세로
			int n = sc.nextInt();
			// 배추갯수
			int k = sc.nextInt();

			land = new int[n+2][m+2];

			for (int baechoo = 0; baechoo < k; baechoo++) {
				int y = sc.nextInt()+1;
				int x = sc.nextInt()+1;
				land[x][y] = 1;
			}
			
			
			int count = 0;
			for (int x = 0; x < n+2; x++) {
				for (int y = 0; y < m+2; y++) {
					if(land[x][y] == 1) {
						haechoongbakmyol(x,y);
						beollae++;
					}
				}
			}
			
			System.out.println(beollae);
		}

	}

	public static void haechoongbakmyol(int x, int y) {
		land[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			if (land[x + dx[i]][y + dy[i]] == 1) {
				haechoongbakmyol(x + dx[i], y + dy[i]);
			}

		}

	}

}