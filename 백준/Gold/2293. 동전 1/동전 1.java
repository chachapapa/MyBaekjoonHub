import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i< n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		Arrays.sort(arr);
		
		int[] money = new int[k+1];
		
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 1 ; j< money.length ; j++) {
				if(j == arr[i]) {
					money[j]++;
				}else if(j>arr[i]){
					money[j] = money[j]+money[j-arr[i]];
				}
			}
//			System.out.println(Arrays.toString(money));
		}
		
		System.out.println(money[k]);
	}

}