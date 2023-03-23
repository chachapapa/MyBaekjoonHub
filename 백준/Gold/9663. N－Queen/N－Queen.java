import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int n;
	static List<Integer> list;
	static int res;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		int t = sc.nextInt();
//
//		for (int test = 1; test <= t; test++) {
			res = 0;
			n = sc.nextInt();

			list = new ArrayList<>();
			place(0);
			System.out.println(res);
//		}

	}

	public static void place(int idx) {

		if (idx == n) {
//			System.out.println(list);
			res++;
			return;
		}

		loop: for (int x = 0; x < n; x++) {
//			if(x == 0) {
//			System.out.println("루프 x값" + x);
//			}
			if (list.contains(x)) {
				continue;
			}
//			if(x==0) {
//			System.out.println("리스트에 "+x+"없음");
//			}
			for (int i = 0; i < list.size(); i++) {
				if (Math.abs(i - idx) == Math.abs(list.get(i) - x)) {
//					if(x == 0) {
//						System.out.println("i 값" + i + "일때 "+Math.abs((i - idx) / (list.get(i) - x)));
//					}
					continue loop;
				}
			}
			
//			System.out.println(idx+"에"+x+"들어감");
			list.add(x);
//			System.out.println(list);
			place(idx + 1);
			list.remove(idx);

		}
	}

}