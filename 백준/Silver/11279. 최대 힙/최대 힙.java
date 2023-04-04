import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			
			int num = sc.nextInt();
			
			if(num >0 ) {
				pq.add(num);
			}else if(!pq.isEmpty()){
				
			System.out.println(pq.poll());
			}else if(pq.isEmpty()) {
				System.out.println(0);
			}
		}
		
		
	}

}