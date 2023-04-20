import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] dy = { -1, 0, 1 };
	static int[][] map;
	static int[] max;
	static int[] min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		max = new int[3];
		min = new int[3];
		
		for(int i = 0 ; i<3 ; i++) {
			int x = sc.nextInt();
			max[i] = x;
			min[i] = x;
		}
		
		
		for(int i = 0 ; i< n-1 ; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			int before0 = max[0];
			int before2 = max[2];
			
			max[0] = Math.max(max[0], max[1])+x;
			max[2] = Math.max(max[1], max[2])+z;
			max[1] = Math.max(Math.max(before0, max[1]), before2)+y;
			
			before0 = min[0];
			before2 = min[2];
			min[0] = Math.min(min[0], min[1])+x;
			min[2] = Math.min(min[1], min[2])+z;
			min[1] = Math.min(Math.min(before0, min[1]), before2)+y;
			
			
		}
		
		
		int first = 0;
		
		int second = Integer.MAX_VALUE;
		
		
		for(int j = 0 ;j<3 ; j++) {
			if(max[j] > first) first = max[j];
			if(min[j] < second) second = min[j];
		}
		
		System.out.println(first+" "+second);
			
		
	}

}