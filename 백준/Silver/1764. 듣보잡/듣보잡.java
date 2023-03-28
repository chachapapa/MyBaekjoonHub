import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int heard = Integer.parseInt(st.nextToken());
		int saw = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> m = new HashMap<>();
		for(int i = 0 ; i < heard ; i++) {
			m.put(br.readLine(),0);
		}
		
		List<String> res = new ArrayList<>();
		
		
		
		
		for(int i =0 ; i< saw ; i++) {
			String name = br.readLine();
			if(m.containsKey(name)) {
				res.add(name);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(res);
		
		for(int i = 0 ; i < res.size() ; i++) {
			sb.append(res.get(i)).append("\n");
		}
		
		System.out.println(res.size());
		System.out.println(sb);
	}

}