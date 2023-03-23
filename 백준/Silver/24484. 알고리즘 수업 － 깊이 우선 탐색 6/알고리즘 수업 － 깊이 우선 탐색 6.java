import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> list;
	static long[] orderarr;
	static long[] deptharr;
	static int order;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		// 정점수
		int n = Integer.parseInt(st.nextToken());
		// 간선수
		int m = Integer.parseInt(st.nextToken());
		// 시작점
		int start = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			StringTokenizer st2 = new StringTokenizer(tmp);
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}

		for (int i = 0; i <= n; i++) {
			Collections.sort(list.get(i), new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}

			});
		}

		order = 1;

		orderarr = new long[n + 1];
		deptharr = new long[n + 1];

		for (int i = 1; i < n + 1; i++) {
			deptharr[i] = -1;
		}

		dfs(start, 0);

		StringBuilder sb = new StringBuilder();

//		for(int i = 1 ; i< n+1 ; i++) {
//			sb.append(orderarr[i]).append("\n");
//		}
//		
//		System.out.println(sb);

//		for(int i = 1 ; i<n+1 ; i++) {
//			sb.append(deptharr[i]).append("\n");
//		}
//		System.out.println(sb);

		long sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum += orderarr[i] * deptharr[i];
		}
		System.out.println(sum);
	}

	public static void dfs(int start, int depth) {
		orderarr[start] = order;
		deptharr[start] = depth;
		order++;
		for (int i = 0; i < list.get(start).size(); i++) {
			if (orderarr[list.get(start).get(i)] == 0) {
				dfs(list.get(start).get(i), depth + 1);
			}
		}
	}

}