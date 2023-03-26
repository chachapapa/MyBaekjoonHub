import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double a = sc.nextDouble() / 100;
		double b = sc.nextDouble() / 100;

//		System.out.println(a + " " + b);

		int[] sosu = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
		double percenta = 0;
		double percentb = 0;
		for (int x : sosu) {

			double gyungwoo = 1;

			for (int i = 18; i > 18 - x; i--) {
				gyungwoo *= i;
				gyungwoo /= 18 - (i - 1);
			}
			percenta += gyungwoo * Math.pow(a, x) * Math.pow(1 - a, 18 - x);
			percentb += gyungwoo * Math.pow(b, x) * Math.pow(1 - b, 18 - x);
		}
		System.out.println(1-(percenta*percentb) );

	}

}