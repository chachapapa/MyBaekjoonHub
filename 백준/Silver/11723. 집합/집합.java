import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		List<Integer> all = new ArrayList<>();
		boolean[] contain = new boolean[21];
		
		for(int i = 1 ; i <= 20 ; i++) {
			all.add(i);
		}
		StringBuilder sb = new StringBuilder();
		String[] command = new String[2];
		
		for(int i = 0 ; i < n ; i ++) {
			command[0] = sc.next();
			if(!(command[0].equals("all") || command[0].equals("empty"))) {
			command[1] = sc.next();
			}
			
//			System.out.println(Arrays.toString(command));
			
			if(command[0].equals("add") && !contain[Integer.parseInt(command[1])]) {
				list.add(Integer.parseInt(command[1]));
				contain[Integer.parseInt(command[1])] = true;
			}
			
			if(command[0].equals("remove") && contain[Integer.parseInt(command[1])]) {
				list.remove(list.indexOf(Integer.parseInt(command[1])));
				contain[Integer.parseInt(command[1])] = false;
			}
			
			if(command[0].equals("check")) {
				if(contain[Integer.parseInt(command[1])]){
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			
			if(command[0].equals("toggle")) {
				if(contain[Integer.parseInt(command[1])]) {
					list.remove(list.indexOf(Integer.parseInt(command[1])));
					contain[Integer.parseInt(command[1])] = false;
				}else {
					list.add(Integer.parseInt(command[1]));
					contain[Integer.parseInt(command[1])] = true;
				}
			}
			
			if(command[0].equals("all")) {
//				list = new ArrayList(all);
//				Collections.copy(list, all);
				for(int j =1 ; j<21 ; j++) {
					if(!contain[j]) {
						list.add(j);
						contain[j] = true;
					}
				}
			}
			
			if(command[0].equals("empty")) {
				list.clear();
				contain = new boolean[21];
			}
		}
		
		System.out.println(sb);
		
	}

}