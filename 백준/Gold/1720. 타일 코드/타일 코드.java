import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		int[] dp = new int[31];
		
		int[][] dpdp = new int[31][31];
		
		
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * 2;
		}
		
		
		if (n % 2 == 0) {
			dpdp[n / 2][n / 2 + 1] = 3;
			dpdp[n / 2 - 1][n / 2 + 2] = 5;
			int i = n / 2 - 2;
			int j = n / 2 + 3;
			
			while (i >= 1 && j <= n) {
				dpdp[i][j] = dpdp[i + 1][j - 1] + dpdp[i + 2][j - 2] * 2;
				i--;
				j++;
			}
			
		}else {
			dpdp[n / 2 + 1][n / 2 + 1] = 1;
			dpdp[n / 2][n / 2 + 2] = 1;
			int i = n / 2 - 1;
			int j = n / 2 + 3;
			
			while (i >= 1 && j <= n) {
				dpdp[i][j] = dpdp[i + 1][j - 1] + dpdp[i + 2][j - 2] * 2;
				i--;
				j++;
			}
			
		}
		
		
		int ans = (dp[n] - dpdp[1][n]) / 2 + dpdp[1][n];
		
		System.out.println(ans);
		
	}
}