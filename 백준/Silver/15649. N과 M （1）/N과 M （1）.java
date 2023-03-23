import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int n;
	static int m;
	static int[] res;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		
		for(int i = 0 ; i<n ; i++) {
			arr[i] = i+1;
		}
		
		res = new int[m];
		
		perm(0,0);
		
	}
	
	public static void perm(int idx, int visited) {
		if(idx == m) {
			for(int i = 0 ; i < res.length ; i++) {
			System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i< n ; i++) {
			if((visited & (1<<i)) != 0 ) continue;
			
			res[idx] = arr[i];
			perm(idx+1,visited|(1<<i));
		}
	}
}