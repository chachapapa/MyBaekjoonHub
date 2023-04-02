import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		int[] num = new int[n];

		int max = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		
		int sum = 0;
		for(int i = 0 ; i<x ; i++) {
			sum += num[i];
		}
		max = sum;
		count = 1;
		for(int i = x ; i<n ; i++) {
			sum += num[i] - num[i-x];
			if(sum == max) {
				count++;
			}else if(sum > max) {
				max = sum;
				count = 1;
			}
			
		}
		
		
		
		
		if(max != 0) {
			System.out.println(max);
			System.out.println(count);
		}else {
			System.out.println("SAD");
		}

	}

}