import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

		}

		int[] arr2 = new int[n];
		int[] idx = new int[n];
		arr2[0] = arr[0];
		idx[0] = 0;
		int limit = 0;
		int length = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr2[length - 1]) {
				arr2[length] = arr[i];
				idx[i] = length;
				limit = i;
				length++;
			} else {
				int lower = 0;
				int upper = length;
				int mid = (lower + upper) / 2;

				while (upper > lower) {
					mid = (lower + upper) / 2;

					if (arr2[mid] < arr[i]) {
						lower = mid + 1;
					} else {
						upper = mid;
					}
				}

				arr2[lower] = arr[i];
				idx[i] = lower;
			}
		}

		System.out.println(length);
		StringBuilder sb = new StringBuilder();
//		System.out.println(Arrays.toString(idx));
//		System.out.println(limit);
		int next = n-1;
		for (int i = length-1; i >=0 ; i--) {
			for (int j = next; j>=0; j--) {
				if (idx[j] == i) {
					arr2[i] = arr[j];
					next = j-1;
					break;
				}
			}

		}
//		System.out.println(Arrays.toString(arr2));
		for(int i = 0 ; i < length ; i++) {
			sb.append(arr2[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}