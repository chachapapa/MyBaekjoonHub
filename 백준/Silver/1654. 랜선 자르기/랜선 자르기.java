import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

				//입력받기
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();//주어진 랜선 개수
				int wanted = sc.nextInt();//목표 랜선 개수
				//랜선 길이 배열에 저장
				int[] arr = new int[num];
				for(int i=0;i<num;i++) arr[i] = sc.nextInt();
				

				Arrays.sort(arr);
				
				long min = 1;
				long max = arr[num-1];
				
				while(min<=max) {
					long mid = (min+max)/2;
					
					int ans = 0;
					for(int x:arr) {
						ans += x/mid;
					}
					if(ans<wanted) {
						max=mid-1;
					}else if(ans>=wanted){
						min = mid+1;
					}
				}
				System.out.println(max);

	}

}