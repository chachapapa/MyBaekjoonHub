import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int store = sc.nextInt();
		int cnt = 0;
		int police = 0;

		int[] map = new int[store];
		
		for (int i = 0; i <= store; i++) {
			int dir = sc.nextInt();
			int length = sc.nextInt();
			int tmp = 0;

			if(dir == 1) {
				tmp = length;
			}

			if(dir == 2) {
				tmp = y + x + y - length;
			}
			
			if(dir == 3) {
				tmp = y + x + y + x - length;
			}
		
			if(dir == 4) {
				tmp = y + length;
			}
			
			if (i < store)
				map[i] = tmp;
			else
				police = tmp;
		}

		for (int i = 0; i < store; i++) {
			
			int path1 = Math.abs(police - map[i]);
			int path2 = 2 * y + 2 * x - path1;
			
			cnt += Math.min(path1, path2);
		}
		System.out.println(cnt);
	}

}