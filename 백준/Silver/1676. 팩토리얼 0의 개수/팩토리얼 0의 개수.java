import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int n = Integer.parseInt(br.readLine());

			
			int count5 = 0;

//			for (int i = n; i >= 1; i--) {
//				int tmp = i;
//
//
//				while (tmp % 5 == 0) {
//					count5++;
//					tmp/=5;
//				}
//			}
			
			while(n/5 != 0) {
			count5+= n/5;
			n /=5;
			}
			
			
			System.out.println(count5);
		}
}