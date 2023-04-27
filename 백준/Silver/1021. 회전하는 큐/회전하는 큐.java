import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static LinkedList<Integer> dq;
	static int[] arr;
	static int[] place;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		m = sc.nextInt();

		dq = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			dq.add(i);
		}
		
		
		arr = new int[m];
		for(int i = 0 ; i < m ; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		int count = 0;
		for(int i = 0 ; i< m ; i++) {
			int goal = arr[i];
			int idx = dq.indexOf(goal);
			
			int half = 0;
			if(dq.size()%2 == 0) {
				half = dq.size()/2-1;
			}else {
				half = dq.size()/2;
			}
			
			if(idx <= half) {
				
				while(dq.peek() != goal) {
				
				dq.add(dq.pollFirst());
				count++;
				}

			}else {
				while(dq.peek() != goal) {
				dq.addFirst(dq.pollLast());
				count++;
				}
			}
			
			dq.poll();
		}
		System.out.println(count);
		
		
	}
}