import java.util.Scanner;

public class Main {
	
	static int n;
	static int r;
	static int c;
	static int size;
	static int count = 0;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt();
		
		r= sc.nextInt();
		c= sc.nextInt();
		size = (int) Math.pow(2,n);
		
		zzz(size, r, c );
		System.out.println(count);
		
	}
	
	
	public static void zzz(int size,int x , int y) {
		if(size == 1)
			return;
		
		if(x < size/2 && y < size/2) {
			zzz(size/2, x, y);
		}
		else if(x < size/2 && y >= size/2) {
			count += size * size / 4;
			zzz(size/2, x, y - size/2);
		}
		else if(x >= size/2 && y < size/2) {
			count += (size * size / 4) * 2;
			zzz(size/2, x - size/2, y);
		}
		else {
			count += (size * size / 4) * 3;
			zzz(size/2, x - size/2, y - size/2);
		}
		
		
		
		
		
	}
}