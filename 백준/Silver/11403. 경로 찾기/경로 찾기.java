import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static List<List<Integer>> list;
	static int[][] res;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] road = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				road[i][j] = sc.nextInt();
			}
		}

		list = new ArrayList<>();
		
		for(int i = 0 ; i<n+1 ; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (road[i][j] == 1) {
					list.get(i + 1).add(j + 1);
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			Collections.sort(list.get(i));
		}
		
//		for(int i = 0 ; i<list.size() ;i++) {
//			System.out.println(list.get(i));
//		}

		
		
		res = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited = new boolean[n + 1];
				dfs(i,i,j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void dfs(int first, int now, int end) {
//		System.out.println("처음 들어온 x값 , 지금값, 목표값"+ first+ now + end);
		visited[now + 1] = true;
		if (list.get(now + 1).contains(end + 1)) {
//			System.out.println("갈수있다!");
			res[first][end] = 1;
		} else if (res[first][end] == 0) {
//			System.out.println("못가네?");
			for (int i = 0; i < list.get(now + 1).size(); i++) {

				if (!visited[list.get(now + 1).get(i)]) {
//					System.out.println("now값 바꿔서 넣자 다시" + (list.get(now+1).get(i)-1) + "로!");
					dfs(first,list.get(now + 1).get(i)-1, end);
				}

			}
		}

	}

}