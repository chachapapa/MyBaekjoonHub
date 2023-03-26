import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class road {
		int end;
		int length;

		public road(int end, int length) {
			this.end = end;
			this.length = length;
		}

		@Override
		public String toString() {
			return "road [end=" + end + ", length=" + length + "]";
		}

	}

	static int n;
	static int d;
	static int min;
	static List<List<road>> list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 지름길 갯수
		n = sc.nextInt();

		// 고속도로 길이
		d = sc.nextInt();

		list = new ArrayList<>();

		for (int i = 0; i < 10000; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			list.get(sc.nextInt()).add(new road(sc.nextInt(), sc.nextInt()));
		}

//		Queue<road> q = new LinkedList<>();
//		
//		q.add(new road(0,0));	

//		int sum = 0;
//		while(!q.isEmpty()) {
//			road now = q.poll();
//			sum += now.length;
//			
//			
//			for(int i = 0 ; i< list.get(now.end).size() ; i++) {
//				q.add(list.get(now.end).get(i));
//			}
//			
//			
//			
//			
//		}

		min = d;

		where(0, 0);
		System.out.println(min);

	}

	public static void where(int now, int length) {

		if (now > d) {
			return;
		}

		if (length >= min) {
			return;
		}

		if (length + (Math.abs(now - d)) < min) {
			min = length + (Math.abs(now - d));
		}

		for (int i = 0; i < list.get(now).size(); i++) {

			where(list.get(now).get(i).end, length + list.get(now).get(i).length);

		}

			for (int i = now + 1; i < d + 1; i++) {
				if (!list.get(i).isEmpty()) {
					where(i, length + (i - now));
				}
			}
	}

}