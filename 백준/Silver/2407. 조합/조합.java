import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger top = BigInteger.ONE;
		BigInteger bottom = BigInteger.ONE;
		for(int i = 0; i < m ; i++) {
			top = top.multiply(BigInteger.valueOf(n-i));
			bottom = bottom.multiply(BigInteger.valueOf(m-i));
		}
//		System.out.println(top);
//		System.out.println(bottom);
		System.out.print(top.divide(bottom));
	}

}