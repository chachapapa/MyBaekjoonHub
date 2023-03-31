import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		//강의갯수
		int n = sc.nextInt();
		//블루레이갯수
		int m = sc.nextInt();
		//강의 용량
		int[] size = new int[n];
		
		int min = 0;
		int max = 0;
		for(int i = 0 ; i< n ; i++) {
			size[i] = sc.nextInt();
			
			if(size[i] > min) {
				min = size[i];
			}
			max += size[i];
		}
		int mid = (max+min)/2;
		while(max>=min) {
			mid = (max+min)/2;
			int empty = mid;
			int count = 1;
			for(int i = 0 ; i < n ; i++) {
				if(size[i] <= empty) {
					empty -= size[i];
				}else {
					count++;
					empty = mid-size[i];
				}
			}
			
			
			if(count > m) {
				min = mid+1;
			}else {
				max = mid-1;
			}
			
		}
		System.out.println(min);
		
		
	}

}