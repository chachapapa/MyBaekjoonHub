import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] time;
	static int n;
	static int min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		time = new int[n];
		for(int i = 0 ; i < n ; i++) {
			time[i] = sc.nextInt();
			
		}
		
		
		Arrays.sort(time);
		int sum = 0 ;
		
		for(int i = 0 ; i < n ; i++) {
			
			sum += time[i]*(n-i);
			
		}
		
		System.out.println(sum);

	}
}