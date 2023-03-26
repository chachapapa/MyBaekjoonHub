import java.util.Scanner;

public class Main {
	static int[] arr;
	static int printdepth;
	static StringBuilder sb;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		arr = new int[(int) (Math.pow(2, n)-1)];

		for (int i = 0; i < Math.pow(2, n)-1; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(printdepth = 0 ; printdepth < n ; printdepth ++) {
			sb = new StringBuilder();
			
			print(0, arr.length-1, 0);
			
			System.out.println(sb);
		}
		
	}
	public static void print(int min, int max , int depth) {
		if (min > max) {
			return;
		}
		
		int mid = (min+max)/2;
		
		if(depth == printdepth) {
			sb.append(arr[mid]).append(" ");
		}
		
		print(min , mid-1 , depth+1);
		print(mid+1, max , depth+1);
	}
}