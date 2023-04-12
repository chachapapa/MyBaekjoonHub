import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] sort = new int[n]; 
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(); 

		for (int i = 0; i < n; i++) {
			int x= sc.nextInt();
			arr[i] = x;
			sort[i] = x;
		}

		Arrays.sort(sort);

		
		int count = 0;
		for (int i : sort) {
			
			if (!m.containsKey(i)) {
				m.put(i, count);
				count++; 
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int key : arr) {
			int x = m.get(key); 
			sb.append(x).append(" ");
		}

		System.out.println(sb);

	}

}