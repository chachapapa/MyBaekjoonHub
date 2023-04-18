import java.util.Scanner;

public class Main {

	static long div;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();
		div = sc.nextLong();

		System.out.println(pow(x, y));
	}

	public static long pow(long x, long y) {

		if (y == 1) {
			return x % div;
		}

		long half = pow(x, y / 2);

		if (y % 2 == 1) {
			return (half * half % div) * x % div;
		}
		
		
		return half * half % div;

	}

}