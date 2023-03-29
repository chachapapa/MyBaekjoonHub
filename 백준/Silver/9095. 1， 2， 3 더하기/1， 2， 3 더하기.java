import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int test = 1 ; test<=t ;test++) {
			
			int[] arr = new int[12];
			
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			
			for(int i = 4; i<12 ; i++) {
				arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
			}
			
			System.out.println(arr[sc.nextInt()]);
			
			
		}
		
	}

}