import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Double n = sc.nextDouble();
		// SK 홀수 , CY짝수
		
		if(n%5 == 2 || n%5 == 0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}

}