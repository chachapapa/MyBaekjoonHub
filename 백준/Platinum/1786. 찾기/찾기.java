import java.util.Scanner;

public class Main {
	
	static int count = 0;
	static StringBuilder sb;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String text = sc.nextLine();

		String pattern = sc.nextLine();
		sb = new StringBuilder();
		kmp(text,pattern);
		
		System.out.println(count);
		System.out.println(sb);

	}

	public static int[] getPi(String pt) {
		int[] pi = new int[pt.length()];

		int j = 0;
		for (int i = 1; i < pt.length(); i++) {
			while (j > 0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}
			if (pt.charAt(i) == pt.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	public static void kmp(String text, String pt) {
		int[] pi = getPi(pt); 
		int j = 0; 
		for(int i = 0; i<text.length(); i++) {
			while(j>0 && text.charAt(i) != pt.charAt(j))
				j = pi[j-1];
			
			
			if(text.charAt(i) == pt.charAt(j)) {
				if(j == pt.length()-1) {
					
					count++;
					sb.append((i-pt.length()+2)).append(" ");
					j = pi[j];
				}else {
					j++;
				}
			}
		}
	}
}