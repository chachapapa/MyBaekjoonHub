import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, String> pocketmon = new HashMap<>();
		Map<String, Integer> number = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			pocketmon.put(i + 1, tmp);
			number.put(tmp, i+1);
		}

		String[] test = new String[m];

		for (int i = 0; i < m; i++) {
			test[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {

			try {
				int now = Integer.parseInt(test[i]);

				sb.append(pocketmon.get(now)).append("\n");
			} catch (Exception e) {
				String now = test[i];

				sb.append(number.get(now)).append("\n");

			}

		}

		System.out.println(sb);

	}

}