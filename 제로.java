package swea_d3;

import java.util.Scanner;

public class 제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1;test<=T;test++) {
			int N = sc.nextInt();
			int ans=0;
			int [] arr = new int[N];
			int index=-1;
			for(int i=0;i<N;i++) {
				int a =sc.nextInt();
				if(a!=0) {
					arr[++index]=a;
				}
				else {
					arr[index--]=0;
				}
			}
			for(int i=0;i<arr.length;i++) {
				ans+=arr[i];
			}
			System.out.println("#"+test+" "+ans);
		}
	}
}
