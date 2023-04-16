import java.util.Scanner;

public class Main {
	
	static int[] post;
	static int[] in;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		in = new int[n];
		post = new int[n];
		
		for(int i = 0 ; i< n ; i++) {
			in[i]=  sc.nextInt();
		}
		
		for(int i = 0 ; i < n ; i++) {
			post[i]  = sc.nextInt();
		}
		pre(0,n-1,0,n-1);
		
		System.out.println(sb);
	}	
	
	static StringBuilder sb = new StringBuilder();
	
	public static void pre(int instart, int inend, int pststart, int pstend) {
		if(instart<=inend && pststart<=pstend) {
			
			
			sb.append(post[pstend]).append(" ");
//			System.out.println(sb);
			int bound =	0;
			
			for(int i = instart ; i <= inend ; i++) {
				if(in[i] == post[pstend]) {
					bound = i;
					break;
				}
			}
			
//			System.out.println("인 범위"+instart+" "+(bound-1)+" 포스트 범위"+ pststart +" "+ (pststart+bound-instart-1));
			pre(instart, bound-1, pststart, pststart+bound-instart-1);
//			System.out.println("인 범위"+(bound+1)+" "+inend+" 포스트 범위"+ (pststart+bound-instart) +" "+ (pstend-1));
			pre(bound+1, inend , pststart+bound-instart , pstend-1);
			
			
			
		}
	}

}