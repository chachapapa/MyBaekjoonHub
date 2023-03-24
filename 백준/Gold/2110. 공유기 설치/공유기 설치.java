import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//집 갯수
		int n = sc.nextInt();
		
		//공유기갯수
		int m = sc.nextInt();
		
		//집들 위치
		int[] house = new int[n];
		for(int i = 0 ; i<n ; i++) {
			house[i] = sc.nextInt();
		}
		
		Arrays.sort(house);
		
		
		int narrow = 1;
		int wide = house[n-1]-house[0]+1;
		int mid = (narrow+wide)/2;
		while(wide>narrow) {
//			System.out.println("가장좁게" + narrow + " 가장넓게" + wide);
			
			mid = (narrow+wide)/2;
//			System.out.println("설치해볼 거리" + mid);
			int count = 1;
			int now = house[0];
			for(int i = 1 ; i< n ; i++) {
				if((house[i] - now)>=mid) {
					count++;
					now = house[i];
				}
			}
			
			if(count < m) {
				wide = mid;
			}else {
				narrow = mid+1;
			}
		}
		System.out.println(wide-1);
	}

}