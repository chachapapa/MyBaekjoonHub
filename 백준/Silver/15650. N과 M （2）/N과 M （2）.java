import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int n;
	static int m;
	static int[] res;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		
		for(int i = 0 ; i<n ; i++) {
			arr[i] = i+1;
		}
		
		//결과 순열을 넣을 res 배열.
		res = new int[m];
		
		perm(0,0);
		
	}
	
	public static void perm(int idx, int visited) {
		//idx가 목표 길이와 같아진다면, 출력하고 함수 종료.
		if(idx == m) {
			for(int i = 0 ; i < res.length ; i++) {
			System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//arr의 원소들을 하나씩 조회하면서 
		//visited..는 
		
		for(int i = 0 ; i< n ; i++) {
			//visited와 1<<i 가 일치하는게 하나라도 있다면 아래 코드를 스킵.
			if((visited & (1<<i)) != 0 || (idx>=1 && res[idx-1] >= arr[i])) continue;
			
			//visited와 1<<i 의 모든 자릿수가 다르면 실행되는 코드
			//결과값에 arr[i] 넣기.
			res[idx] = arr[i];
			//visited나 1<<i의 자리값이 하나라도 1이면 1 반환.
			perm(idx+1,visited|(1<<i));
		}
	}
}