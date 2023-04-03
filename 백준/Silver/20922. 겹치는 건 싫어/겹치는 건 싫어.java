import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int n = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		str = br.readLine();
		st = new StringTokenizer(str);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		int[] count = new int[100001];

		int max = 0;
		count[arr[start]]++;
		
		
		while (end < n-1) {
			
			end++;
			count[arr[end]]++;

			if (count[arr[end]] > k) {
				
				
				
				
				while(count[arr[end]] >k) {
				count[arr[start]]--;
				start++;
				}
				
				
				if(n-start+1 <= max) {
					break;
				}
			}
			
			
			
			int sum = end - start + 1;
			if (sum > max)
				max = sum;
		
			
			
		}

		System.out.println(max);
	}

}