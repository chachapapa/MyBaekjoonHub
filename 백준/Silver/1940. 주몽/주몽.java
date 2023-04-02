import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] num = new int[n];
		
		for(int i = 0; i<n ; i++) {
			num[i] = sc.nextInt();
		}
		
		int count = 0;
		for(int i = 0 ; i< n-1 ; i++) {
			for(int j =i+1 ; j< n ; j++) {
				if(num[i] + num[j] == m) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}