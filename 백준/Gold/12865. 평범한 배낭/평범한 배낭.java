import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int limit = sc.nextInt();

		int[][] ing = new int[n][2];

		for (int i = 0; i < n; i++) {

			ing[i][0] = sc.nextInt();
			ing[i][1] = sc.nextInt();

		}

//			Arrays.sort(ing,new Comparator<int[]>() {
//
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					return Integer.compare(o1[0], o2[0]);
//				}
//				
//				
//				
//			});

//			for(int i = 0 ; i< n ; i++) {
//				System.out.println(Arrays.toString(ing[i]));
//			}

		int[] cal = new int[limit + 1];

		for (int i = 0; i < n; i++) {

			for (int j = limit; j >= ing[i][0]; j--) {

				if (cal[j] < cal[j - ing[i][0]] + ing[i][1]) {
					cal[j] = cal[j - ing[i][0]] + ing[i][1];
				}

			}
//				System.out.println(Arrays.toString(cal));

		}

		System.out.println(cal[limit]);

	}

}