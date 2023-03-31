import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] arr;
	static int sum;
	static char preysj;
	static int res;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		arr = str.toCharArray();

		sum = 0;

		preysj = '+';
		res = 0;

//		System.out.println(Arrays.toString(arr));
		sum(0);
		System.out.println(res);
	}

	public static void sum(int startidx) {

		for (int i = startidx; i < arr.length; i++) {
			sum = 0;
			if (arr[i] == '+') {
//				System.out.println("i값은?" + i);

				for (int j = startidx; j < i; j++) {
					sum += (arr[j] - '0') * Math.pow(10, i - 1 - j);
				}
//				System.out.println("다음 연산자 + 입니다" + sum);

				if (preysj == '-') {
					res -= sum;
				} else {
					res += sum;
					preysj = '+';

				}
//				System.out.println("res값은"+ res);
				sum(i+1);

			} else if (arr[i] == '-') {
//				System.out.println("i값은?" + i);
				for (int j = startidx; j < i; j++) {
					sum += (arr[j] - '0') * Math.pow(10, i - 1 - j);
				}
//				System.out.println("다음연산자 - 입니다." + sum);

				if (preysj == '-') {
					res -= sum;
				} else {
					res += sum;
					preysj = '-';
				}
//				System.out.println("res값은"+ res);
				sum(i+1);
				
			} else if (i == arr.length-1) {
//				System.out.println("i값은?" + i);
				for (int j = startidx; j <= i; j++) {
					sum += (arr[j] - '0') * Math.pow(10, i - j);
				}
//				System.out.println("끝이에여"+sum);
				if (preysj == '-') {
					res -= sum;
				} else {
					res += sum;
				}
				
//				System.out.println("res값은"+ res);

			}
			
			if(arr[i] == '+' || arr[i] == '-' || i == arr.length-1) {
				break;
			}
			
		}
		
	}
}