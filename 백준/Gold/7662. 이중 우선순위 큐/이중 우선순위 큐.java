import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int test = 1; test <= t; test++) {

			int n = sc.nextInt();
			TreeMap<Integer, Integer> tmap = new TreeMap<>();
			
			for (int i = 0; i < n; i++) {

				String comm = sc.next();

				int num = sc.nextInt();

				if (comm.equals("I")) {
					tmap.put(num, tmap.getOrDefault(num, 0)+1);
				}

				if (!tmap.isEmpty()) {
					if (comm.equals("D")) {
						if (num == -1) {
							if(tmap.get(tmap.firstKey()) == 1) {
							tmap.remove(tmap.firstKey());
							}else {
								tmap.put(tmap.firstKey(), tmap.get(tmap.firstKey())-1);
							}
							
							
						} else if (num == 1) {
							if(tmap.get(tmap.lastKey()) == 1) {
								tmap.remove(tmap.lastKey());
								}else {
									tmap.put(tmap.lastKey(), tmap.get(tmap.lastKey())-1);
								}
						}
					}
				}
			}

			
			if(tmap.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(tmap.lastKey()+" "+tmap.firstKey());
			}
			
		}

	}

}