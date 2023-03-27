import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i<n ; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		int[] arr2 = new int[n];
		
		arr2[0] = arr[0];
		int length = 1;
		
		for(int i = 1 ; i< n ; i++ ) {
			if(arr[i] > arr2[length-1]) {
				arr2[length] = arr[i];
				length++;
			}else {
				int lower = 0;
				int upper = length;
				int mid  = (lower+upper)/2;
				
				
				while(upper>lower) {
					mid = (lower+upper)/2;
					
					if(arr2[mid] < arr[i]) {
						lower = mid+1;
					}else {
						upper = mid;
					}
				}
				
				arr2[lower] = arr[i];
				
			}
		}
		
		System.out.println(length);
	}
		
}