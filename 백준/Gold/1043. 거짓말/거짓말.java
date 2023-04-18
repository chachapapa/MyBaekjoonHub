import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사람수
		int n = sc.nextInt();

		// 파티 수
		int m = sc.nextInt();

		// false가 이야기해도 되는 파티 수.
		boolean[] quiet = new boolean[m];
		List<Integer>[] party = new ArrayList[m];
		
		for(int i = 0 ; i<m ; i++) {
			party[i]=new ArrayList<>();
		}

		// 진실을 아는 사람수
		int truth = sc.nextInt();

		int[] who = new int[truth];

		for (int i = 0; i < truth; i++) {
			who[i] = sc.nextInt();
		}

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int howmany = sc.nextInt();
			int[] people = new int[howmany];

			for (int j = 0; j < howmany; j++) {
				int x = sc.nextInt();
				people[j] = x;
				party[i].add(x);
			}

			for (int j = 0; j < people.length; j++) {
				for (int x = 0; x < people.length; x++) {
					if (j != x)
						list.get(people[j]).add(people[x]);
				}
			}

		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < who.length; i++) {
			q.add(who[i]);
			visited[who[i]] = true;
		}
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < list.get(now).size(); i++) {
				if (!visited[list.get(now).get(i)]) {
					q.add(list.get(now).get(i));
					visited[list.get(now).get(i)] = true;
				}
			}
		}
		
		for(int i = 0 ; i< m ; i++) {
			for(int j = 0 ; j<party[i].size() ; j++) {
				if(visited[party[i].get(j)]) {
					quiet[i] = true;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i< m ; i++) {
			if(!quiet[i]) ans++;
		}
		
		System.out.println(ans);
	}

}